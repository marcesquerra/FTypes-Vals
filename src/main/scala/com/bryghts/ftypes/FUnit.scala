package com.bryghts.ftypes

import com.bryghts.ftypes.components.{FBuilder, FAnyCompanion, FAny}

import scala.concurrent.Future

/**
 * Created by Marc Esquerrà on 18/03/15.
 */
class FUnit(val future: Future[Unit]) extends FAny[Unit, FUnit]{
    override protected val builder: FBuilder[Unit, FUnit] = FUnit
}

object FUnit extends FAnyCompanion[Unit, FUnit] {
    override def apply(in: Future[Unit]): FUnit = new FUnit(in)
}
