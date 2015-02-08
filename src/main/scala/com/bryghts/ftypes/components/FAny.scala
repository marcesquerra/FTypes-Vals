package com.bryghts.ftypes.components

import com.bryghts.ftypes.{FString, FInt, FBoolean}

import scala.concurrent.duration.Duration
import scala.concurrent._
import scala.language.implicitConversions

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
trait FAny[T, S <: FAny[T, S]] extends Awaitable[T] {self =>

    val future: Future[T]
    protected val companion: FAnyCompanion[T, S]

    def toFString(implicit ec: ExecutionContext):FString = future.map(_.toString)

    @throws[InterruptedException](classOf[InterruptedException])
    @throws[TimeoutException](classOf[TimeoutException])
    override def ready(atMost: Duration)(implicit permit: CanAwait) = {future.ready(atMost)(permit); this}

    @throws[Exception](classOf[Exception])
    override def result(atMost: Duration)(implicit permit: CanAwait) = future.result(atMost)(permit)

    def ==[FB <: FAny[_, FB]]      (x: FB)(implicit ec: ExecutionContext): FBoolean =
        future.flatMap(a => x.future.map(b => a == b))

    def !=[FB <: FAny[_, FB]]      (x: FB)(implicit ec: ExecutionContext): FBoolean =
        future.flatMap(a => x.future.map(b => a != b))

    def equals[FB <: FAny[_, FB]]  (x: FB)(implicit ec: ExecutionContext): FBoolean =
        future.flatMap(a => x.future.map(b => a equals b))

    def fhashCode(implicit ec: ExecutionContext):FInt = future.map(_.hashCode())
}

trait FAnyCompanion[T, U <: FAny[T, U]] extends Function1[Future[T], U]{

    def apply(in: Future[T]): U

    implicit def apply        (value: T)        : U =
        apply(Future.successful(value))

    implicit def implicitApply(value: Future[T]): U =
        apply(value)

}


