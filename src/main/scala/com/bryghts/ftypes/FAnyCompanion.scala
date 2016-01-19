package com.bryghts.ftypes

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 18/01/2016.
 */
trait FAnyCompanion[A, FA <: FAny[A, FA]]
{

    def apply(in: Future[A])(implicit executionContext: ExecutionContext): FA

    def apply(value: A)(implicit executionContext: ExecutionContext): FA =
        apply(Future.successful(value))

}
