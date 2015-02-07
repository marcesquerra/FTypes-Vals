package com.bryghts.ftypes

import scala.concurrent.{ExecutionContext, Future}
import scala.language.higherKinds

package object components {


    trait FNumeric[FA <: FNumber[_, FA], FB <: FNumber[_, FB], FR <: FNumber[_, FR]] {
        def plus (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR
        def minus(fa: FA, fb: FB)(implicit ec: ExecutionContext): FR
        def times(fa: FA, fb: FB)(implicit ec: ExecutionContext): FR
        def div  (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR

        def compare(fx: FA, fy: FB)(implicit ec: ExecutionContext): FInt
        def lteq   (fx: FA, fy: FB)(implicit ec: ExecutionContext): FBoolean = compare(fx, fy).future.map(_ <= 0)
        def gteq   (fx: FA, fy: FB)(implicit ec: ExecutionContext): FBoolean = compare(fx, fy).future.map(_ >= 0)
        def lt     (fx: FA, fy: FB)(implicit ec: ExecutionContext): FBoolean = compare(fx, fy).future.map(_ <  0)
        def gt     (fx: FA, fy: FB)(implicit ec: ExecutionContext): FBoolean = compare(fx, fy).future.map(_ <  0)

//        def max    (x: FA, y: FB): FR       = If (gteq(x, y)) x else y
//        def min    (x: FA, y: FB): FR       = If (lteq(x, y)) x else y

    }

    trait Numeric[A, B, R] {
        def plus  (a: A, b: B): R
        def minus (x: A, y: B): R
        def times (x: A, y: B): R
        def div   (x: A, y: B): R

        def compare(x: A, y: B): Int
        def lteq   (x: A, y: B): Boolean = compare(x, y) <= 0
        def gteq   (x: A, y: B): Boolean = compare(x, y) >= 0
        def lt     (x: A, y: B): Boolean = compare(x, y) < 0
        def gt     (x: A, y: B): Boolean = compare(x, y) > 0
    }

    def FDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD]]
            (ck: FAnyCompanion[K, FK], cd: FAnyCompanion[D, FD])
            (c: D => K)
            (implicit num: scala.Fractional[K]): (FNumeric[FK, FD, FK], FNumeric[FD, FK, FK]) =
                    defs(ck, cd, ck)(identity, c, (k, d) => num.div(k, d))(num)

    def IDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD]]
            (ck: FAnyCompanion[K, FK], cd: FAnyCompanion[D, FD])
            (c: D => K)
            (implicit num: scala.Integral[K]): (FNumeric[FK, FD, FK], FNumeric[FD, FK, FK]) =
                    defs(ck, cd, ck)(identity, c, (k, d) => num.quot(k, d))(num)

    def FDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
            (ck: FAnyCompanion[K, FK], cd: FAnyCompanion[D, FD], cr: FAnyCompanion[R, FR])
            (fromK: K => R, fromD: D => R)
            (implicit num: scala.Fractional[R]): (FNumeric[FK, FD, FR], FNumeric[FD, FK, FR]) =
                    defs(ck, cd, cr)(fromK, fromD, (k, d) => num.div(k, d))

    def IDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
            (ck: FAnyCompanion[K, FK], cd: FAnyCompanion[D, FD], cr: FAnyCompanion[R, FR])
            (fromK: K => R, fromD: D => R)
            (implicit num: scala.Integral[R]): (FNumeric[FK, FD, FR], FNumeric[FD, FK, FR]) =
                    defs(ck, cd, cr)(fromK, fromD, (k, d) => num.quot(k, d))

    private def defs[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
        (ck: FAnyCompanion[K, FK], cd: FAnyCompanion[D, FD], cr: FAnyCompanion[R, FR])(fromK: K => R, fromD: D => R, fdiv: (R, R) => R)(implicit num: scala.Numeric[R]): (FNumeric[FK, FD, FR], FNumeric[FD, FK, FR]) = {

        implicit object BaseNumKL extends Numeric[K, D, R] {
            def plus    (k: K, d: D): R   = num.plus    (fromK(k), fromD(d))
            def minus   (k: K, d: D): R   = num.minus   (fromK(k), fromD(d))
            def times   (k: K, d: D): R   = num.times   (fromK(k), fromD(d))
            def div     (k: K, d: D): R   = fdiv        (fromK(k), fromD(d))
            def compare (k: K, d: D): Int = num.compare (fromK(k), fromD(d))
        }

        implicit object BaseNumKR extends Numeric[D, K, R] {
            def plus    (d: D, k: K): R   = num.plus    (fromD(d), fromK(k))
            def minus   (d: D, k: K): R   = num.minus   (fromD(d), fromK(k))
            def times   (d: D, k: K): R   = num.times   (fromD(d), fromK(k))
            def div     (d: D, k: K): R   = fdiv        (fromD(d), fromK(k))
            def compare (d: D, k: K): Int = num.compare (fromK(k), fromD(d))
        }

        implicit object FNumKL extends FNumeric[FK, FD, FR] {
            private def op[RR, FRR <: FNumber[RR, FRR]](fk: FK, fd: FD, crr: FAnyCompanion[RR, FRR] = cr)(f: (K, D) => RR)(implicit executionContext: ExecutionContext): FRR =
                 crr(fk.future.flatMap(k => fd.future.map(d => f(k, d))))

            def plus(fk: FK, fd: FD)(implicit executionContext: ExecutionContext): FR =
                 op(fk, fd)(BaseNumKL.plus)

            def minus(fk: FK, fd: FD)(implicit executionContext: ExecutionContext): FR =
                op(fk, fd)(BaseNumKL.minus)

            def times(fk: FK, fd: FD)(implicit executionContext: ExecutionContext): FR =
                op(fk, fd)(BaseNumKL.times)

            def div(fk: FK, fd: FD)(implicit executionContext: ExecutionContext): FR =
                op(fk, fd)(BaseNumKL.div)

            def compare(fk: FK, fd: FD)(implicit executionContext: ExecutionContext): FInt =
                op(fk, fd, FInt)(BaseNumKL.compare)

        }

        implicit object FNumKR extends FNumeric[FD, FK, FR] {

            private def op[RR, FRR <: FNumber[RR, FRR]](fd: FD, fk: FK, crr: FAnyCompanion[RR, FRR] = cr)(f: (D, K) => RR)(implicit executionContext: ExecutionContext): FRR =
                crr(fd.future.flatMap(d => fk.future.map(k => f(d, k))))

            def plus(fd: FD, fk: FK)(implicit executionContext: ExecutionContext): FR =
                op(fd, fk)(BaseNumKR.plus)

            def minus(fd: FD, fk: FK)(implicit executionContext: ExecutionContext): FR =
                op(fd, fk)(BaseNumKR.minus)

            def times(fd: FD, fk: FK)(implicit executionContext: ExecutionContext): FR =
                op(fd, fk)(BaseNumKR.times)

            def div(fd: FD, fk: FK)(implicit executionContext: ExecutionContext): FR =
                op(fd, fk)(BaseNumKR.div)

            def compare(fd: FD, fk: FK)(implicit executionContext: ExecutionContext): FInt =
                op(fd, fk, FInt)(BaseNumKR.compare)

        }

        (FNumKL, FNumKR)
    }

    /**
     * Created by Marc Esquerrà on 22/01/2015.
     */
    abstract class FNumber[T, S <: FNumber[T, S]] extends FAny[T, S] {

        protected def fa = this.asInstanceOf[S]

        protected def op[R, FR <: FNumber[R, FR]](fb: S, cr: FAnyCompanion[R, FR] = companion)(f: (T, T) => R)(implicit executionContext: ExecutionContext): FR =
            cr(future.flatMap(a => fb.future.map(b => f(a, b))))

        private def op[R, FR <: FNumber[R, FR]](cr: FAnyCompanion[R, FR])(f: T => R)(implicit executionContext: ExecutionContext):FR =
            cr(future.map(f))

        private def op(f: T => T)(implicit executionContext: ExecutionContext):S =
            companion(future.map(f))

        def +[FB <: FNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
            num.plus(fa, fb)

        def +(fb: S)(implicit num: scala.Numeric[T], executionContext: ExecutionContext):S =
            op(fb)(num.plus)

        def -[FB <: FNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
            num.minus(fa, fb)

        def -(fb: S)(implicit num: scala.Numeric[T], executionContext: ExecutionContext):S =
            op(fb)(num.minus)

        def *[FB <: FNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
            num.times(fa, fb)

        def *(fb: S)(implicit num: scala.Numeric[T], executionContext: ExecutionContext):S =
            op(fb)(num.times)

        def /[FB <: FNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
            num.div(fa, fb)

        def unari_-(implicit num: scala.Numeric[T], executionContext: ExecutionContext):S =
            op(num.negate)

        def abs()(implicit num: scala.Numeric[T], executionContext: ExecutionContext):S =
            op(num.abs)

        def signum()(implicit num: scala.Numeric[T], executionContext: ExecutionContext): FInt =
            op(FInt)(num.signum)

        def <[FB <: FFNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
            num.lt(fa, fb)

        def >[FB <: FFNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
            num.gt(fa, fb)

        def <=[FB <: FFNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
            num.lteq(fa, fb)

        def >=[FB <: FFNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
            num.gteq(fa, fb)
    }

    abstract class FFNumber[T, S <: FFNumber[T, S]](protected val companion: FAnyCompanion[T, S]) extends FNumber[T, S] {

        def /(fb: S)(implicit num: scala.Fractional[T], executionContext: ExecutionContext):S =
            op(fb)(num.div)

    }

    abstract class FINumber[T, S <: FINumber[T, S]](protected val companion: FAnyCompanion[T, S]) extends FNumber[T, S] {

        def /(fb: S)(implicit num: scala.Integral[T], executionContext: ExecutionContext):S =
            op(fb)(num.quot)

        def %(fb: S)(implicit num: scala.Integral[T], executionContext: ExecutionContext):S =
            op(fb)(num.rem)

    }
}




