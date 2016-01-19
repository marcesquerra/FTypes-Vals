package com.bryghts.ftypes.async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 18/03/15.
 */
class FUnit(val future: Future[Unit])(override implicit protected val executionContext: ExecutionContext) extends Any[Unit, FUnit]{
}

object FUnit extends AnyCompanion[Unit, FUnit] {
    override def apply(in: Future[Unit])(implicit executionContext: ExecutionContext): FUnit = new FUnit(in)
}
