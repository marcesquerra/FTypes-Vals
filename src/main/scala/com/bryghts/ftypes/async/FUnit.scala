package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 18/03/15.
 */
class FUnit(val future: Future[scala.Unit])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Unit, FUnit]{
}

object FUnit extends async.AnyCompanion[scala.Unit, FUnit] {
    override def apply(in: Future[scala.Unit])(implicit executionContext: ExecutionContext): FUnit = new FUnit(in)
}
