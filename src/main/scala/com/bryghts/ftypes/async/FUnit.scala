package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 18/03/15.
 */
class FUnit(val future: Future[Unit])(override implicit protected val executionContext: ExecutionContext) extends async.Any[Unit, FUnit]{
}

object FUnit extends async.AnyCompanion[Unit, FUnit] {
    override def apply(in: Future[Unit])(implicit executionContext: ExecutionContext): FUnit = new FUnit(in)
}
