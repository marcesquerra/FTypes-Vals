package com.bryghts.ftypes
package statements

import scala.concurrent._

class Do[T] private(t: Function0[T]) {
    def While(p: => FBoolean)(implicit ec: ExecutionContext): Future[Unit] =
    {
        t()
        p.future.flatMap {

            case true =>
                While(p)

            case false =>
                Future.successful(())
        }
    }

}

object Do {

    def apply[T](t: => T): Do[T] = new Do(() => t)


}

