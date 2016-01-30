package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}
import scala.language.implicitConversions

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Double(override          val future: Future[scala.Double])
            (override implicit val executionContext: ExecutionContext) extends async.AnyBase[scala.Double, async.Double]{

    @inline def op[R, FR <: async.AnyBase[R, FR], B](r: async.Builder[R, FR])(fb: async.AnyBase[B, _])(f: (scala.Double, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    @inline def op[R, FR <: async.AnyBase[R, FR]](r: async.Builder[R, FR], f: scala.Double => R): FR =
        r(future.map(f))

    def toByte: async.Byte = op(async.Byte, _.toByte)
    def toShort: async.Short = op(async.Short, _.toShort)
    def toChar: async.Char = op(async.Char, _.toChar)
    def toInt: async.Int = op(async.Int, _.toInt)
    def toLong: async.Long = op(async.Long, _.toLong)
    def toFloat: async.Float = op(async.Float, _.toFloat)
    def toDouble: async.Double = this

    def unary_+ : async.Double = op(async.Double, _.unary_+ )
    def unary_- : async.Double = op(async.Double, _.unary_- )

    def ==(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ == _)

    def !=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ != _)

    def <(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ < _)

    def <=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ <= _)

    def >(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ > _)

    def >=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ >= _)

    def +(x: async.Byte): async.Double = op(async.Double)(x)(_ + _)
    def +(x: async.Short): async.Double = op(async.Double)(x)(_ + _)
    def +(x: async.Char): async.Double = op(async.Double)(x)(_ + _)
    def +(x: async.Int): async.Double = op(async.Double)(x)(_ + _)
    def +(x: async.Long): async.Double = op(async.Double)(x)(_ + _)
    def +(x: async.Float): async.Double = op(async.Double)(x)(_ + _)
    def +(x: async.Double): async.Double = op(async.Double)(x)(_ + _)

    def -(x: async.Byte): async.Double = op(async.Double)(x)(_ - _)
    def -(x: async.Short): async.Double = op(async.Double)(x)(_ - _)
    def -(x: async.Char): async.Double = op(async.Double)(x)(_ - _)
    def -(x: async.Int): async.Double = op(async.Double)(x)(_ - _)
    def -(x: async.Long): async.Double = op(async.Double)(x)(_ - _)
    def -(x: async.Float): async.Double = op(async.Double)(x)(_ - _)
    def -(x: async.Double): async.Double = op(async.Double)(x)(_ - _)

    def *(x: async.Byte): async.Double = op(async.Double)(x)(_ * _)
    def *(x: async.Short): async.Double = op(async.Double)(x)(_ * _)
    def *(x: async.Char): async.Double = op(async.Double)(x)(_ * _)
    def *(x: async.Int): async.Double = op(async.Double)(x)(_ * _)
    def *(x: async.Long): async.Double = op(async.Double)(x)(_ * _)
    def *(x: async.Float): async.Double = op(async.Double)(x)(_ * _)
    def *(x: async.Double): async.Double = op(async.Double)(x)(_ * _)

    def /(x: async.Byte): async.Double = op(async.Double)(x)(_ / _)
    def /(x: async.Short): async.Double = op(async.Double)(x)(_ / _)
    def /(x: async.Char): async.Double = op(async.Double)(x)(_ / _)
    def /(x: async.Int): async.Double = op(async.Double)(x)(_ / _)
    def /(x: async.Long): async.Double = op(async.Double)(x)(_ / _)
    def /(x: async.Float): async.Double = op(async.Double)(x)(_ / _)
    def /(x: async.Double): async.Double = op(async.Double)(x)(_ / _)

    def %(x: async.Byte): async.Double = op(async.Double)(x)(_ % _)
    def %(x: async.Short): async.Double = op(async.Double)(x)(_ % _)
    def %(x: async.Char): async.Double = op(async.Double)(x)(_ % _)
    def %(x: async.Int): async.Double = op(async.Double)(x)(_ % _)
    def %(x: async.Long): async.Double = op(async.Double)(x)(_ % _)
    def %(x: async.Float): async.Double = op(async.Double)(x)(_ % _)
    def %(x: async.Double): async.Double = op(async.Double)(x)(_ % _)
}


object Double extends Builder[scala.Double, async.Double]{

    implicit val from = Builder[scala.Double, async.Double]{(f, ec) => new async.Double(f)(ec)}

    implicit def implicitDoubleToAsyncDouble (v: scala.Double)    (implicit executionContext: ExecutionContext): async.Double  =
        async.Double from v

    override def apply(in: Future[scala.Double])(implicit executionContext: ExecutionContext): async.Double =
        new async.Double(in)

}
