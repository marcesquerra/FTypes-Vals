package com.bryghts.ftypes

import scala.concurrent.ExecutionContext

/**
 * Created by Marc Esquerrà on 29/01/2016.
 */
package object async {

    type Any[T <: Any[T]] = async.AnyBase[_, T]

    def True  (implicit executionContext: ExecutionContext) = async.Boolean(true)
    def False (implicit executionContext: ExecutionContext) = async.Boolean(false)

}
