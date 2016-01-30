package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}
import scala.language.implicitConversions

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Float(override          val future: Future[scala.Float])
           (override implicit val executionContext: ExecutionContext) extends async.AnyBase[scala.Float, async.Float]{

    def op[R, FR <: async.AnyBase[R, FR], B](r: async.Builder[R, FR])(fb: async.AnyBase[B, _])(f: (scala.Float, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: async.AnyBase[R, FR]](r: async.Builder[R, FR], f: scala.Float => R): FR =
        r(future.map(f))

    def toFByte: async.Byte = op(async.Byte, _.toByte)
    def toFShort: async.Short = op(async.Short, _.toShort)
    def toFChar: async.Char = op(async.Char, _.toChar)
    def toFInt: async.Int = op(async.Int, _.toInt)
    def toFLong: async.Long = op(async.Long, _.toLong)
    def toFFloat: async.Float = this
    def toFDouble: async.Double = op(async.Double, _.toDouble)

    def unary_+ : async.Float = op(async.Float, _.unary_+ )
    def unary_- : async.Float = op(async.Float, _.unary_- )

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

    def +(x: async.Byte): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Short): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Char): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Int): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Long): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Float): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Double): async.Double = op(async.Double)(x)(_ + _)

    def -(x: async.Byte): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Short): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Char): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Int): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Long): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Float): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Double): async.Double = op(async.Double)(x)(_ - _)

    def *(x: async.Byte): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Short): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Char): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Int): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Long): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Float): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Double): async.Double = op(async.Double)(x)(_ * _)

    def /(x: async.Byte): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Short): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Char): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Int): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Long): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Float): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Double): async.Double = op(async.Double)(x)(_ / _)

    def %(x: async.Byte): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Short): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Char): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Int): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Long): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Float): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Double): async.Double = op(async.Double)(x)(_ % _)
}


object Float extends Builder[scala.Float, async.Float]{

    implicit val from = Builder[scala.Float, async.Float]{(f, ec) => new async.Float(f)(ec)}

    implicit def implicitFloatToAsyncFloat (v: scala.Float)    (implicit executionContext: ExecutionContext): async.Float  =
        async.Float from v

    override def apply(in: Future[scala.Float])(implicit executionContext: ExecutionContext): async.Float =
        new async.Float(in)

}
