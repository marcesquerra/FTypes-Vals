package com.bryghts.ftypes
package async

import scala.concurrent._
import scala.language.implicitConversions

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
trait AnyBase[A, FA <: AnyBase[A, FA]] {self =>

    implicit def executionContext:ExecutionContext

    val future: Future[A]

    def ===   [VFB, FB >: FA <: async.Any[FB]]  (x: VFB)(implicit f: VFB => FB): async.Boolean =
        async.Boolean(future.flatMap(a => x.future.map(b => a == b)))

    def =!=   [VFB, FB >: FA <: async.Any[FB]]  (x: VFB)(implicit f: VFB => FB): async.Boolean =
        async.Boolean(future.flatMap(a => x.future.map(b => a != b)))

    def unsafeEquals[FB <: async.Any[_]]  (x: FB): async.Boolean =
        async.Boolean(future.flatMap(a => x.future.map(b => a equals b)))

}

