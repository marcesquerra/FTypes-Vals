package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 18/03/15.
 */
class Unit(val future: Future[scala.Unit])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Unit, async.Unit]{
}

object Unit extends async.AnyCompanion[scala.Unit, async.Unit] {
    override def apply(in: Future[scala.Unit])(implicit executionContext: ExecutionContext): async.Unit = new async.Unit(in)
}
