package com.bryghts.ftypes.async

import scala.concurrent._

object FBoolean extends AnyCompanion[Boolean, FBoolean]
{

    override def apply(in: Future[Boolean])(implicit executionContext: ExecutionContext): FBoolean =
        new FBoolean(in)

}

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
class FBoolean private(val future: Future[Boolean])(override implicit protected val executionContext: ExecutionContext) extends Any[Boolean, FBoolean]
{

    private def op(x: FBoolean, f: (Boolean, Boolean) => Boolean):FBoolean =
            FBoolean(future.flatMap(a => x.future.map(b => f(a, b))))

    def unary_!              : FBoolean = FBoolean(future.map(! _))

    def ||      (x: FBoolean): FBoolean = op(x, _ || _)
    def &&      (x: FBoolean): FBoolean = op(x, _ && _)
    def |       (x: FBoolean): FBoolean = op(x, _ |  _)
    def &       (x: FBoolean): FBoolean = op(x, _ &  _)
    def ^       (x: FBoolean): FBoolean = op(x, _ ^  _)

}

