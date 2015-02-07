package com.bryghts.ftypes

import scala.concurrent.{Await, Awaitable}
import scala.concurrent.duration.Duration

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
object AwaitResult {

    def apply[T](a: Awaitable[T])(implicit timeout: Duration) = Await.result(a, timeout)

}
