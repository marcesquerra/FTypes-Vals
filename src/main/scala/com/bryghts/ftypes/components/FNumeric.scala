package com.bryghts.ftypes
package components

import scala.concurrent.ExecutionContext

trait FNumeric[FA <: FNumber[_, FA], FB, FR] {

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

trait FIntegralNumeric[FA <: FNumber[_, FA], FB, FR] {
    def rem     (a: FA, b: FB)(implicit ec: ExecutionContext): FR
}

object FNumeric {

    def apply[A, FA <: FNumber[A, FA], B, FB <: FNumber[B, FB], R, FR <: FNumber[R, FR]](cr: FNumberCompanion[R, FR], BaseNumAB: IntegralNumeric[A, B, R]):FIntegralNumeric[FA, FB, FR] =
        new FNumericForBaseIntegralNumeric[A, FA, B, FB, R, FR](cr, BaseNumAB)

    def apply[A, FA <: FNumber[A, FA], B, FB <: FNumber[B, FB], R, FR <: FNumber[R, FR]](cr: FNumberCompanion[R, FR], BaseNumAB: FractionalNumeric[A, B, R]):FNumeric[FA, FB, FR] =
        new FNumericForBaseNumeric[A, FA, B, FB, R, FR](cr, BaseNumAB)

    def mixed[A, FA <: FNumber[A, FA], B, R, FR <: FNumber[R, FR]](cr: FNumberCompanion[R, FR], BaseNumAB: IntegralNumeric[A, B, R]):FIntegralNumeric[FA, B, FR] =
        new FNumericMixedForBaseIntegralNumeric[A, FA, B, R, FR](cr, BaseNumAB)

    def mixed[A, FA <: FNumber[A, FA], B, R, FR <: FNumber[R, FR]](cr: FNumberCompanion[R, FR], BaseNumAB: FractionalNumeric[A, B, R]):FNumeric[FA, B, FR] =
        new FNumericMixedForBaseNumeric[A, FA, B, R, FR](cr, BaseNumAB)
}

class FNumericForBaseNumeric[A, FA <: FNumber[A, FA], B, FB <: FNumber[B, FB], R, FR <: FNumber[R, FR]]
          (cr: FNumberCompanion[R, FR], BaseNumAB: Numeric[A, B, R])                                     extends FNumeric[FA, FB, FR] {

    protected def op[RR, FRR <: FNumber[RR, FRR]](fa: FA, fb: FB, crr: FNumberCompanion[RR, FRR] = cr)(f: (A, B) => RR)(implicit executionContext: ExecutionContext): FRR =
        crr(fa.future.flatMap(a => fb.future.map(b => f(a, b))))

    def plus(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FR =
        op(fa, fb)(BaseNumAB.plus)

    def minus(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FR =
        op(fa, fb)(BaseNumAB.minus)

    def times(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FR =
        op(fa, fb)(BaseNumAB.times)

    def div(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FR =
        op(fa, fb)(BaseNumAB.div)

    def compare(fa: FA, fb: FB)(implicit executionContext: ExecutionContext): FInt =
        op(fa, fb, FInt)(BaseNumAB.compare)

    def max    (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR =
        op(fa, fb)(BaseNumAB.max)

    def min    (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR =
        op(fa, fb)(BaseNumAB.min)

}

class FNumericForBaseIntegralNumeric[A, FA <: FNumber[A, FA], B, FB <: FNumber[B, FB], R, FR <: FNumber[R, FR]]
          (cr: FNumberCompanion[R, FR], BaseNumAB: IntegralNumeric[A, B, R])                                     extends FNumericForBaseNumeric[A,FA, B, FB, R, FR](cr, BaseNumAB)
                                                                                                                    with FIntegralNumeric[FA, FB, FR]
{

    def rem    (fa: FA, fb: FB)(implicit ec: ExecutionContext): FR =
        op(fa, fb)(BaseNumAB.rem)

}


class FNumericMixedForBaseNumeric[A, FA <: FNumber[A, FA], B, R, FR <: FNumber[R, FR]]
          (cr: FNumberCompanion[R, FR], BaseNumAB: Numeric[A, B, R])                                     extends FNumeric[FA, B, FR] {

    protected def op[RR, FRR <: FNumber[RR, FRR]](fa: FA, b: B, crr: FNumberCompanion[RR, FRR] = cr)(f: (A, B) => RR)(implicit executionContext: ExecutionContext): FRR =
        crr(fa.future.map(a => f(a, b)))

    def plus(fa: FA, b: B)(implicit executionContext: ExecutionContext): FR =
        op(fa, b)(BaseNumAB.plus)

    def minus(fa: FA, b: B)(implicit executionContext: ExecutionContext): FR =
        op(fa, b)(BaseNumAB.minus)

    def times(fa: FA, b: B)(implicit executionContext: ExecutionContext): FR =
        op(fa, b)(BaseNumAB.times)

    def div(fa: FA, b: B)(implicit executionContext: ExecutionContext): FR =
        op(fa, b)(BaseNumAB.div)

    def compare(fa: FA, b: B)(implicit executionContext: ExecutionContext): FInt =
        op(fa, b, FInt)(BaseNumAB.compare)

    def max    (fa: FA, b: B)(implicit ec: ExecutionContext): FR =
        op(fa, b)(BaseNumAB.max)

    def min    (fa: FA, b: B)(implicit ec: ExecutionContext): FR =
        op(fa, b)(BaseNumAB.min)

}

class FNumericMixedForBaseIntegralNumeric[A, FA <: FNumber[A, FA], B, R, FR <: FNumber[R, FR]]
           (cr: FNumberCompanion[R, FR], BaseNumAB: IntegralNumeric[A, B, R])                                     extends FNumericMixedForBaseNumeric[A,FA, B, R, FR](cr, BaseNumAB)
                                                                                                                     with FIntegralNumeric[FA, B, FR]
{

    def rem    (fa: FA, b: B)(implicit ec: ExecutionContext): FR =
        op(fa, b)(BaseNumAB.rem)

}
