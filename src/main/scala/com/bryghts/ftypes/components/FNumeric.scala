package com.bryghts.ftypes
package components

import com.bryghts.numerics.{PolyNumeric, FractionalPolyNumeric, IntegralPolyNumeric}

import scala.concurrent.ExecutionContext

trait FNumeric[FA, FB] {

    type FR

    def plus   (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR
    def minus  (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR
    def times  (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR
    def div    (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR

    def compare(fx: FA, fy: FB)(implicit ec: ExecutionContext): FInt
    def lteq   (fx: FA, fy: FB)(implicit ec: ExecutionContext): FBoolean = compare(fx, fy).future.map(_ <= 0)
    def gteq   (fx: FA, fy: FB)(implicit ec: ExecutionContext): FBoolean = compare(fx, fy).future.map(_ >= 0)
    def lt     (fx: FA, fy: FB)(implicit ec: ExecutionContext): FBoolean = compare(fx, fy).future.map(_ <  0)
    def gt     (fx: FA, fy: FB)(implicit ec: ExecutionContext): FBoolean = compare(fx, fy).future.map(_ <  0)

    def max    (fx: FA, fy: FB)(implicit ec: ExecutionContext): FR
    def min    (fx: FA, fy: FB)(implicit ec: ExecutionContext): FR

}

trait FIntegralNumeric[FA, FB] extends FNumeric[FA, FB]{
    def rem     (a: FA, b: FB)(implicit ec: ExecutionContext): FR
}

trait FFractionalNumeric[FA, FB] extends FNumeric[FA, FB]{
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

abstract class FNumericForBaseNumeric[A, FA <: FNumber[A, FA], B, FB <: FNumber[B, FB], R]
        (protected val num: PolyNumeric[A, B, R])                                     extends FNumeric[FA, FB] {

    protected val builder: FBuilder[R, FR]

    protected def op(fa: FA, fb: FB)(f: (A, B) => R)(implicit executionContext: ExecutionContext): FR =
        builder(for {
            a <- fa.future
            b <- fb.future
        } yield f(a, b))

    protected def iop(fa: FA, fb: FB)(f: (A, B) => Int)(implicit executionContext: ExecutionContext): FInt =
        fa.future.flatMap(a => fb.future.map(b => f(a, b)))


    def plus(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FR =
        op(fa, fb)(num.plus)

    def minus(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FR =
        op(fa, fb)(num.minus)

    def times(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FR =
        op(fa, fb)(num.times)

    def div(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FR =
        op(fa, fb)(num.div)

    def compare(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FInt =
        iop(fa, fb)(num.compare)

    def max    (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR =
        op(fa, fb)(num.max)

    def min    (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR =
        op(fa, fb)(num.min)

}

abstract class FNumericForBaseIntegralNumeric[A, FA <: FNumber[A, FA], B, FB <: FNumber[B, FB], R]
        (override protected val num: IntegralPolyNumeric[A, B, R])                                   extends FNumericForBaseNumeric[A,FA, B, FB, R](num)
                                                                                                        with FIntegralNumeric[FA, FB]
{

    def rem    (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR =
        op(fa, fb)(num.rem)

}

abstract class FNumericForBaseFractionalNumeric[A, FA <: FNumber[A, FA], B, FB <: FNumber[B, FB], R]
        (override protected val num: FractionalPolyNumeric[A, B, R])                                 extends FNumericForBaseNumeric[A,FA, B, FB, R](num)
                                                                                                     with FFractionalNumeric[FA, FB]
{


}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


abstract class MixedFNumericForBaseNumeric[A, FA <: FNumber[A, FA], B, R]
            (protected val num: PolyNumeric[A, B, R])                                     extends FNumeric[FA, B] {

    protected val builder: FBuilder[R, FR]

    protected def op(fa: FA, b: B)(f: (A, B) => R)(implicit executionContext: ExecutionContext): FR =
        builder(for {
            a <- fa.future
        } yield f(a, b))

    protected def iop(fa: FA, b: B)(f: (A, B) => Int)(implicit executionContext: ExecutionContext): FInt =
        fa.future.map(a => f(a, b))


    def plus(fa: FA, b: B)(implicit executionContext: ExecutionContext): FR =
        op(fa, b)(num.plus)

    def minus(fa: FA, b: B)(implicit executionContext: ExecutionContext): FR =
        op(fa, b)(num.minus)

    def times(fa: FA, b: B)(implicit executionContext: ExecutionContext): FR =
        op(fa, b)(num.times)

    def div(fa: FA, b: B)(implicit executionContext: ExecutionContext): FR =
        op(fa, b)(num.div)

    def compare(fa: FA, b: B)(implicit executionContext: ExecutionContext): FInt =
        iop(fa, b)(num.compare)

    def max    (fa: FA, b: B)(implicit ec: ExecutionContext): FR =
        op(fa, b)(num.max)

    def min    (fa: FA, b: B)(implicit ec: ExecutionContext): FR =
        op(fa, b)(num.min)

}

abstract class MixedFNumericForBaseIntegralNumeric[A, FA <: FNumber[A, FA], B, R]
        (override protected val num: IntegralPolyNumeric[A, B, R])                                   extends MixedFNumericForBaseNumeric[A,FA, B, R](num)
                                                                                                        with FIntegralNumeric[FA, B]
{

    def rem    (fa: FA, b: B)(implicit ec: ExecutionContext): FR =
        op(fa, b)(num.rem)

}

abstract class MixedFNumericForBaseFractionalNumeric[A, FA <: FNumber[A, FA], B, R]
        (override protected val num: FractionalPolyNumeric[A, B, R])                                 extends MixedFNumericForBaseNumeric[A,FA, B, R](num)
                                                                                                        with FFractionalNumeric[FA, B]
{


}
