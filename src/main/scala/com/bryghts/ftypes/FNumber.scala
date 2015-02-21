package com.bryghts.ftypes

import scala.concurrent.{ExecutionContext, Future}
import scala.language.implicitConversions
import components._

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

    def +[FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
        num.plus(fa, fb)

    def -[FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
        num.minus(fa, fb)

    def *[FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
        num.times(fa, fb)

    def /[FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
        num.div(fa, fb)

    def unari_-(implicit num: scala.Numeric[T], executionContext: ExecutionContext):S =
        op(num.negate)

    def abs()(implicit num: scala.Numeric[T], executionContext: ExecutionContext):S =
        op(num.abs)

    def signum()(implicit num: scala.Numeric[T], executionContext: ExecutionContext): FInt =
        op(FInt)(num.signum)

    def <  [FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
        num.lt(fa, fb)

    def >  [FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
        num.gt(fa, fb)

    def <= [FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
        num.lteq(fa, fb)

    def >= [FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FBoolean =
        num.gteq(fa, fb)

    def max[FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
        num.max(fa, fb)

    def min[FB, FR](fb: FB)(implicit num: FNumeric[S, FB, FR], ec: ExecutionContext):FR =
        num.min(fa, fb)
}

abstract class FFNumber[T, S <: FFNumber[T, S]](protected val companion: FNumberCompanion[T, S]) extends FNumber[T, S] {


}

abstract class FINumber[T, S <: FINumber[T, S]](protected val companion: FNumberCompanion[T, S]) extends FNumber[T, S] {

        def %[FB, FR](fb: FB)(implicit num: FIntegralNumeric[S, FB, FR], ec: ExecutionContext):FR =
            num.rem(fa, fb)

}

trait FNumberCompanion[T, U <: FNumber[T, U]] extends FAnyCompanion[T, U] with ((Future[T]) => U) {

    def apply(in: Future[T]): U

    implicit override def apply        (value: T)        : U =
        apply(Future.successful(value))

    implicit override def implicitApply(value: Future[T]): U =
        apply(value)

}




