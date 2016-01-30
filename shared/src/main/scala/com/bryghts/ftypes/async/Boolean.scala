package com.bryghts.ftypes
package async

import scala.concurrent._

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
class Boolean private(override          val future: Future[scala.Boolean])
                     (override implicit val executionContext: ExecutionContext) extends async.AnyBase[scala.Boolean, async.Boolean]
{

    @inline private def op(x: async.Boolean, f: (scala.Boolean, scala.Boolean) => scala.Boolean):async.Boolean =
            async.Boolean.from(future.flatMap(a => x.future.map(b => f(a, b))))

    def unary_!              : async.Boolean = async.Boolean.from(future.map(! _))

    def ||      (x: async.Boolean): async.Boolean = op(x, _ || _)
    def &&      (x: async.Boolean): async.Boolean = op(x, _ && _)
    def |       (x: async.Boolean): async.Boolean = op(x, _ |  _)
    def &       (x: async.Boolean): async.Boolean = op(x, _ &  _)
    def ^       (x: async.Boolean): async.Boolean = op(x, _ ^  _)

}


object Boolean extends Builder[scala.Boolean, async.Boolean]{

    implicit val from = Builder[scala.Boolean, async.Boolean]{(f, ec) => new async.Boolean(f)(ec)}

    implicit def implicitBooleanToAsyncBoolean (v: scala.Boolean)    (implicit executionContext: ExecutionContext): async.Boolean  =
        async.Boolean from v

    override def apply(in: Future[scala.Boolean])(implicit executionContext: ExecutionContext): async.Boolean =
        new async.Boolean(in)

}
