package com.bryghts.ftypes.components

import com.bryghts.ftypes.{FInt, FString, FBoolean}

import scala.concurrent.duration.Duration
import scala.concurrent._
import scala.language.implicitConversions

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
trait FAny[A, FA <: FAny[A, FA]] extends Awaitable[A] {self =>

    val future: Future[A]
    protected val builder: FBuilder[A, FA]

    def toFString(implicit ec: ExecutionContext):FString = FString(future.map(_.toString))

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

trait FBuilder[A, FA] {
    
    def apply(a: A): FA
    def apply(in: Future[A]): FA

}

trait FBuilderFrom[A] {
    type FType
}

trait FBuilderOf[FA] {
    type Type
    def apply(a: Type): FA
    def apply(in: Future[Type]): FA
}

trait FAnyCompanion[A, FA <: FAny[A, FA]] extends FBuilder[A, FA]
                                             with FBuilderFrom[A]
                                             with FBuilderOf[FA]
{

    type FType = FA
    type Type  = A

    def apply(in: Future[A]): FA

    implicit def apply        (value: A)        : FA =
        apply(Future.successful(value))

    implicit def implicitApply(value: Future[A]): FA =
        apply(value)

}


