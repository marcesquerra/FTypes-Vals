package com.bryghts.ftypes

import com.bryghts.ftypes.components.{FAnyCompanion, FAny}

import scala.concurrent.duration.Duration
import scala.concurrent._
import scala.language.implicitConversions

object FBoolean extends FAnyCompanion[Boolean, FBoolean]
{
    val ftrue  = FBoolean(true)
    val ffalse = FBoolean(false)
}

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
case class FBoolean(future: Future[Boolean]) extends FAny[Boolean, FBoolean]
{

    protected val companion = FBoolean

    def op(x: FBoolean, f: (Boolean, Boolean) => Boolean)(implicit ec: ExecutionContext) =
            FBoolean(future.flatMap(a => x.future.map(b => f(a, b))))

    def unary_!              (implicit ec: ExecutionContext): FBoolean = future.map(! _)
    def ||      (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ || _)
    def &&      (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ && _)
    def |       (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ |  _)
    def &       (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ &  _)
    def ^       (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ ^  _)

}


class If[+T]
        (p: FBoolean, t: => T)(implicit ec: ExecutionContext)
    extends Awaitable[Option[T]]
{

    private val r: Future[Option[T]] = p.future.map(if(_) Some(true) else None).map(_.map(_ => t))

    def Else[U >: T](orElse: => U):Future[U] = r.map(_.getOrElse(orElse))

    @throws[InterruptedException](classOf[InterruptedException])
    @throws[TimeoutException](classOf[TimeoutException])
    override def ready(atMost: Duration)(implicit permit: CanAwait) = {r.ready(atMost)(permit); this}

    @throws[Exception](classOf[Exception])
    override def result(atMost: Duration)(implicit permit: CanAwait) = r.result(atMost)(permit)
}


object If {
    def apply[T](p: FBoolean)(t: => T)(implicit ec: ExecutionContext): If[T] = new If[T](p, t)(ec)
}

