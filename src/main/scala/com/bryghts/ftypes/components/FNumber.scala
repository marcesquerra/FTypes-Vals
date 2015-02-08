package com.bryghts.ftypes

import scala.concurrent.{ExecutionContext, Future}
import scala.language.higherKinds

/**
 * Sample Comment
 */
package object components {


    def FDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD]]
            (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD])
            (c: D => K)
            (implicit num: scala.Fractional[K]): (FNumeric[FK, FD, FK], FNumeric[FD, FK, FK]) =
                    fdefs(ck, cd, ck)(identity, c, num)

    def IDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD]]
            (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD])
            (c: D => K)
            (implicit num: scala.Integral[K]): (FNumeric[FK, FD, FK], FNumeric[FD, FK, FK]) =
                    idefs(ck, cd, ck)(identity, c, num)

    def FDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
            (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD], cr: FNumberCompanion[R, FR])
            (fromK: K => R, fromD: D => R)
            (implicit num: scala.Fractional[R]): (FNumeric[FK, FD, FR], FNumeric[FD, FK, FR]) =
                    fdefs(ck, cd, cr)(fromK, fromD, num)

    def IDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
            (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD], cr: FNumberCompanion[R, FR])
            (fromK: K => R, fromD: D => R)
            (implicit num: scala.Integral[R]): (FNumeric[FK, FD, FR], FNumeric[FD, FK, FR]) =
                    idefs(ck, cd, cr)(fromK, fromD, num)

    def FDefinitions[T, FT <: FNumber[T, FT]]
        (c: FNumberCompanion[T, FT])(implicit num: scala.Fractional[T]): FNumeric[FT, FT, FT] = {

        def f(in:T):T = in

        val BaseNum   = Numeric [T, T, T](f _, f _, num)
        val FNum      = FNumeric[T, FT, T, FT, T, FT](c, BaseNum)

        FNum
    }

    def IDefinitions[T, FT <: FNumber[T, FT]]
        (c: FNumberCompanion[T, FT])(implicit num: scala.Integral[T]): FNumeric[FT, FT, FT] = {

        def f(in:T):T = in

        val BaseNum   = Numeric [T, T, T](f _, f _, num)
        val FNum      = FNumeric[T, FT, T, FT, T, FT](c, BaseNum)

        FNum
    }

    private def fdefs[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
        (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD], cr: FNumberCompanion[R, FR])(fromK: K => R, fromD: D => R, num: scala.Fractional[R]): (FNumeric[FK, FD, FR], FNumeric[FD, FK, FR]) = {

        val BaseNumKL = Numeric [K, D, R](fromK, fromD, num)
        val BaseNumKR = Numeric [D, K, R](fromD, fromK, num)
        val FNumKL    = FNumeric[K, FK, D, FD, R, FR](cr, BaseNumKL)
        val FNumKR    = FNumeric[D, FD, K, FK, R, FR](cr, BaseNumKR)

        (FNumKL, FNumKR)
    }

    private def idefs[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
        (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD], cr: FNumberCompanion[R, FR])(fromK: K => R, fromD: D => R, num: scala.Integral[R]): (FNumeric[FK, FD, FR], FNumeric[FD, FK, FR]) = {

        val BaseNumKL = Numeric [K, D, R](fromK, fromD, num)
        val BaseNumKR = Numeric [D, K, R](fromD, fromK, num)
        val FNumKL    = FNumeric[K, FK, D, FD, R, FR](cr, BaseNumKL)
        val FNumKR    = FNumeric[D, FD, K, FK, R, FR](cr, BaseNumKR)

        (FNumKL, FNumKR)
    }

    /**
     * Created by Marc Esquerrà on 22/01/2015.
     */
    abstract class FNumber[T, S <: FNumber[T, S]] extends FAny[T, S] {

        protected def fa = this.asInstanceOf[S]

        protected val companion: FNumberCompanion[T, S]

        private def op[R, FR <: FNumber[R, FR]](cr: FNumberCompanion[R, FR])(f: T => R)(implicit executionContext: ExecutionContext):FR =
            cr(future.map(f))

        private def op(f: T => T)(implicit executionContext: ExecutionContext):S =
            companion(future.map(f))

        def +[FB <: FNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
            num.plus(fa, fb)

        def -[FB <: FNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
            num.minus(fa, fb)

        def *[FB <: FNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
            num.times(fa, fb)

        def /[FB <: FNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
            num.div(fa, fb)

        def unari_-(implicit num: scala.Numeric[T], executionContext: ExecutionContext):S =
            op(num.negate)

        def abs()(implicit num: scala.Numeric[T], executionContext: ExecutionContext):S =
            op(num.abs)

        def signum()(implicit num: scala.Numeric[T], executionContext: ExecutionContext): FInt =
            op(FInt)(num.signum)

        def <  [FB <: FFNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
            num.lt(fa, fb)

        def >  [FB <: FFNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
            num.gt(fa, fb)

        def <= [FB <: FFNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
            num.lteq(fa, fb)

        def >= [FB <: FFNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
            num.gteq(fa, fb)
    }

    abstract class FFNumber[T, S <: FFNumber[T, S]](protected val companion: FNumberCompanion[T, S]) extends FNumber[T, S] {


    }

    abstract class FINumber[T, S <: FINumber[T, S]](protected val companion: FNumberCompanion[T, S]) extends FNumber[T, S] {

//        def %[FB <: FNumber[_, FB], FR <: FNumber[_, FR]](fb: FB)(implicit num: FINumeric[S, FB, FR], ec: ExecutionContext):FR =
//            num.div(fa, fb)

    }

    trait FNumberCompanion[T, U <: FNumber[T, U]] extends FAnyCompanion[T, U] with Function1[Future[T], U] {

        def apply(in: Future[T]): U

        implicit override def apply        (value: T)        : U =
            apply(Future.successful(value))

        implicit override def implicitApply(value: Future[T]): U =
            apply(value)

    }
}




