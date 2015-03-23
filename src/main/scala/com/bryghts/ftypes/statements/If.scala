package com.bryghts.ftypes
package statements

import scala.concurrent._
import scala.concurrent.duration.Duration


class If[+T] private (p: FBoolean, t: => T)(implicit ec: ExecutionContext)
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

