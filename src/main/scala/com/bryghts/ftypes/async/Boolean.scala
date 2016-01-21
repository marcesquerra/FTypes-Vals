package com.bryghts.ftypes
package async

import scala.concurrent._

object Boolean extends async.AnyCompanion[scala.Boolean, async.Boolean]
{

    override def apply(in: Future[scala.Boolean])(implicit executionContext: ExecutionContext): async.Boolean =
        new async.Boolean(in)

}

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
class Boolean private(override val future: Future[scala.Boolean])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Boolean, async.Boolean]
{

    private def op(x: async.Boolean, f: (scala.Boolean, scala.Boolean) => scala.Boolean):async.Boolean =
            async.Boolean(future.flatMap(a => x.future.map(b => f(a, b))))

    def unary_!              : async.Boolean = async.Boolean(future.map(! _))

    def ||      (x: async.Boolean): async.Boolean = op(x, _ || _)
    def &&      (x: async.Boolean): async.Boolean = op(x, _ && _)
    def |       (x: async.Boolean): async.Boolean = op(x, _ |  _)
    def &       (x: async.Boolean): async.Boolean = op(x, _ &  _)
    def ^       (x: async.Boolean): async.Boolean = op(x, _ ^  _)

}

