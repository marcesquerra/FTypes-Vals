package com.bryghts.ftypes.components


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

    def max    (x: A, y: B): R
    def min    (x: A, y: B): R
}

trait IntegralNumeric[A, B, R] extends Numeric[A, B, R] {
    def rem    (x: A, y: B): R
}

trait FractionalNumeric[A, B, R] extends Numeric[A, B, R] {

}

object Numeric {

    def apply[A, B, R](fromA: A => R, fromB: B => R, num: scala.Fractional[R]): FractionalNumeric[A, B, R] =
        new NumericForFractional[A, B, R](fromA, fromB, num)

    def apply[A, B, R](fromA: A => R, fromB: B => R, num: scala.Integral[R]): IntegralNumeric[A, B, R] =
        new NumericForIntegral[A, B, R](fromA, fromB, num)

}








////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// HELPERS
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


trait NumericForScalaNumeric[A, B, R] extends Numeric[A, B, R] {

    protected val num: scala.Numeric[R]

    protected val fromA: A => R
    protected val fromB: B => R

    def plus    (a: A, b: B): R   = num.plus    (fromA(a), fromB(b))
    def minus   (a: A, b: B): R   = num.minus   (fromA(a), fromB(b))
    def times   (a: A, b: B): R   = num.times   (fromA(a), fromB(b))
    def compare (a: A, b: B): Int = num.compare (fromA(a), fromB(b))

    def max     (a: A, b: B): R   = if (gteq(a, b)) fromA(a) else fromB(b)
    def min     (a: A, b: B): R   = if (lteq(a, b)) fromA(a) else fromB(b)
}

class NumericForFractional[A, B, R](
                                       protected val fromA: A => R,
                                       protected val fromB: B => R,
                                       protected val num: scala.Fractional[R]) extends NumericForScalaNumeric[A, B, R]
                                                                                  with FractionalNumeric[A, B, R]
{
    def div     (a: A, b: B): R   = num.div     (fromA(a), fromB(b))
}

class NumericForIntegral[A, B, R](
                                     protected val fromA: A => R,
                                     protected val fromB: B => R,
                                     protected val num: scala.Integral[R]) extends NumericForScalaNumeric[A, B, R]
                                                                              with IntegralNumeric[A, B, R]
{
    def div     (a: A, b: B): R   = num.quot     (fromA(a), fromB(b))
    def rem     (a: A, b: B): R   = num.rem      (fromA(a), fromB(b))
}
