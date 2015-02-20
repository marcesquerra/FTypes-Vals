package com.bryghts.ftypes
package statements

import scala.concurrent._

object While {

    def apply[T](p: => FBoolean)(t: => T)(implicit ec: ExecutionContext): Future[Unit] =
        p.future.flatMap {

            case true =>
                t
                apply(p)(t)

            case false =>
                Future.successful(())
        }

}

