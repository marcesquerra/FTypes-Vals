package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 18/03/15.
 */
class Unit(override          val future: Future[scala.Unit])
          (override implicit val executionContext: ExecutionContext) extends async.AnyBase[scala.Unit, async.Unit]{
}



object Unit extends Builder[scala.Unit, async.Unit]{

    implicit val from = Builder[scala.Unit, async.Unit]{(f, ec) => new async.Unit(f)(ec)}

    implicit def implicitUnitToAsyncUnit (v: scala.Unit)    (implicit executionContext: ExecutionContext): async.Unit  =
        async.Unit from v

    override def apply(in: Future[scala.Unit])(implicit executionContext: ExecutionContext): async.Unit =
        new async.Unit(in)

}
