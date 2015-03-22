package com.bryghts.ftypes

import components._

import scala.concurrent.ExecutionContext

/**
* Created by Marc Esquerrà on 22/01/2015.
*/
abstract class FNumber[A, FA <: FNumber[A, FA]] extends FAny[A, FA] {

    protected def fa = this.asInstanceOf[FA]

    private def op[R, FR <: FNumber[R, FR]](cr: FAnyCompanion[R, FR])(f: A => R)(implicit executionContext: ExecutionContext) =
        cr.apply(future.map(f))

    private def op(f: A => A)(implicit executionContext: ExecutionContext) =
        builder.apply(future.map(f))

    def +[FB](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext): num.type#FR =
        num.plus(fa, fb)

    def -[FB](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext) =
        num.minus(fa, fb)

    def *[FB, FR](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext) =
        num.times(fa, fb)

    def /[FB, FR](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext) =
        num.div(fa, fb)

    def unari_-(implicit num: Numeric[A], executionContext: ExecutionContext) =
        op(num.negate _)

    def abs()(implicit num: Numeric[A], executionContext: ExecutionContext) =
        op(num.abs _)

    def signum()(implicit num: scala.Numeric[A], executionContext: ExecutionContext): FInt =
        op(FInt)(num.signum)

    def <  [FB](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext):FBoolean =
        num.lt(fa, fb)

    def >  [FB](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext):FBoolean =
        num.gt(fa, fb)

    def <= [FB](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext):FBoolean =
        num.lteq(fa, fb)

    def >= [FB](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext):FBoolean =
        num.gteq(fa, fb)

    def max[FB](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext) =
        num.max(fa, fb)

    def min[FB](fb: FB)(implicit num: FNumeric[FA, FB], ec: ExecutionContext) =
        num.min(fa, fb)
}

abstract class FFNumber[A, FA <: FFNumber[A, FA]](protected val builder: FAnyCompanion[A, FA]) extends FNumber[A, FA] {


}

abstract class FINumber[A, FA <: FINumber[A, FA]](protected val builder: FAnyCompanion[A, FA]) extends FNumber[A, FA] {

        def %[FB](fb: FB)(implicit num: FIntegralNumeric[FA, FB], ec: ExecutionContext) =
            num.rem(fa, fb)

}

trait FNumberCompanion[A, FA <: FAny[A, FA]] extends FAnyCompanion[A, FA] {


}




