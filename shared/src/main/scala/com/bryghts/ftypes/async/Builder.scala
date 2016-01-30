package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 18/01/2016.
 */
trait Builder[A, FA <: async.AnyBase[A, FA]]
{

    def apply(in: Future[A])(implicit executionContext: ExecutionContext): FA

    def apply(value: A)(implicit executionContext: ExecutionContext): FA =
        apply(Future.successful(value))

    def apply(in: Future[FA])(implicit executionContext: ExecutionContext, dummyImplicit: DummyImplicit): FA =
        apply(in.flatMap(_.future))

}

object Builder {

    def apply[A, FA <: async.AnyBase[A, FA]](f: (Future[A], ExecutionContext) => FA) = new Builder[A, FA] {
        override def apply(in: Future[A])(implicit executionContext: ExecutionContext): FA =
            f(in, executionContext)
    }

}
