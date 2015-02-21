package com.bryghts.ftypes.helpers

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Awaitable}

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
object AwaitResult {

    def apply[T](a: Awaitable[T])(implicit timeout: Duration) = Await.result(a, timeout)

}
