package com.bryghts.ftypes
package components

import scala.concurrent.ExecutionContext
import statements._

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

    def max    (x: FA, y: FB)(implicit ec: ExecutionContext): FR
    def min    (x: FA, y: FB)(implicit ec: ExecutionContext): FR

}

trait FIntegralNumeric[FA <: FNumber[_, FA], FB <: FNumber[_, FB], FR <: FNumber[_, FR]] {
    def rem     (a: FA, b: FB)(implicit ec: ExecutionContext): FR
}

object FNumeric {

    def apply[A, FA <: FNumber[A, FA], B, FB <: FNumber[B, FB], R, FR <: FNumber[R, FR]](cr: FNumberCompanion[R, FR], BaseNumAB: IntegralNumeric[A, B, R]):FIntegralNumeric[FA, FB, FR] =
        new FNumericForBaseIntegralNumeric[A, FA, B, FB, R, FR](cr, BaseNumAB)

    def apply[A, FA <: FNumber[A, FA], B, FB <: FNumber[B, FB], R, FR <: FNumber[R, FR]](cr: FNumberCompanion[R, FR], BaseNumAB: FractionalNumeric[A, B, R]):FNumeric[FA, FB, FR] =
        new FNumericForBaseNumeric[A, FA, B, FB, R, FR](cr, BaseNumAB)
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