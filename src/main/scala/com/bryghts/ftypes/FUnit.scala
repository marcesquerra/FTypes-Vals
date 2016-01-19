package com.bryghts.ftypes


import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 18/03/15.
 */
class FUnit(val future: Future[Unit])(override implicit protected val executionContext: ExecutionContext) extends FAny[Unit, FUnit]{
}

object FUnit extends FAnyCompanion[Unit, FUnit] {
    override def apply(in: Future[Unit])(implicit executionContext: ExecutionContext): FUnit = new FUnit(in)
}
