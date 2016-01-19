package com.bryghts.ftypes

import scala.concurrent._
import scala.concurrent.duration.Duration

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
trait FAny[A, FA <: FAny[A, FA]] extends Awaitable[A] {self =>

    implicit protected def executionContext:ExecutionContext

    val future: Future[A]

    @throws[InterruptedException](classOf[InterruptedException])
    @throws[TimeoutException](classOf[TimeoutException])
    override def ready(atMost: Duration)(implicit permit: CanAwait) = {future.ready(atMost)(permit); this}

    @throws[Exception](classOf[Exception])
    override def result(atMost: Duration)(implicit permit: CanAwait) = future.result(atMost)(permit)

    def ==[FB <: FAny[_, FB]]      (x: FB): FBoolean =
        FBoolean(future.flatMap(a => x.future.map(b => a == b)))

    def !=[FB <: FAny[_, FB]]      (x: FB): FBoolean =
        FBoolean(future.flatMap(a => x.future.map(b => a != b)))

    def equals[FB <: FAny[_, FB]]  (x: FB): FBoolean =
        FBoolean(future.flatMap(a => x.future.map(b => a equals b)))

}