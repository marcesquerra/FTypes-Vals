package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Float(val future: Future[scala.Float])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Float, async.Float]{

    def op[R, FR <: async.Any[R, FR], B](r: async.AnyCompanion[R, FR])(fb: async.Any[B, _])(f: (scala.Float, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: async.Any[R, FR]](r: async.AnyCompanion[R, FR], f: scala.Float => R): FR =
        r(future.map(f))

    def toFByte: async.Byte = op(async.Byte, _.toByte)
    def toFShort: FShort = op(FShort, _.toShort)
    def toFChar: async.Char = op(async.Char, _.toChar)
    def toFInt: FInt = op(FInt, _.toInt)
    def toFLong: FLong = op(FLong, _.toLong)
    def toFFloat: async.Float = this
    def toFDouble: async.Double = op(async.Double, _.toDouble)

    def unary_+ : async.Float = op(async.Float, _.unary_+ )
    def unary_- : async.Float = op(async.Float, _.unary_- )

    def ==(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FShort): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FInt): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FLong): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ == _)

    def !=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ != _)

    def <(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FShort): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FInt): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FLong): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ < _)

    def <=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ <= _)

    def >(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FShort): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FInt): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FLong): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ > _)

    def >=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ >= _)

    def +(x: async.Byte): async.Float = op(async.Float)(x)(_ + _)
    def +(x: FShort): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Char): async.Float = op(async.Float)(x)(_ + _)
    def +(x: FInt): async.Float = op(async.Float)(x)(_ + _)
    def +(x: FLong): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Float): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Double): async.Double = op(async.Double)(x)(_ + _)

    def -(x: async.Byte): async.Float = op(async.Float)(x)(_ - _)
    def -(x: FShort): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Char): async.Float = op(async.Float)(x)(_ - _)
    def -(x: FInt): async.Float = op(async.Float)(x)(_ - _)
    def -(x: FLong): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Float): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Double): async.Double = op(async.Double)(x)(_ - _)

    def *(x: async.Byte): async.Float = op(async.Float)(x)(_ * _)
    def *(x: FShort): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Char): async.Float = op(async.Float)(x)(_ * _)
    def *(x: FInt): async.Float = op(async.Float)(x)(_ * _)
    def *(x: FLong): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Float): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Double): async.Double = op(async.Double)(x)(_ * _)

    def /(x: async.Byte): async.Float = op(async.Float)(x)(_ / _)
    def /(x: FShort): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Char): async.Float = op(async.Float)(x)(_ / _)
    def /(x: FInt): async.Float = op(async.Float)(x)(_ / _)
    def /(x: FLong): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Float): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Double): async.Double = op(async.Double)(x)(_ / _)

    def %(x: async.Byte): async.Float = op(async.Float)(x)(_ % _)
    def %(x: FShort): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Char): async.Float = op(async.Float)(x)(_ % _)
    def %(x: FInt): async.Float = op(async.Float)(x)(_ % _)
    def %(x: FLong): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Float): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Double): async.Double = op(async.Double)(x)(_ % _)
}

object Float extends async.AnyCompanion[scala.Float, async.Float] {
    override def apply(in: Future[scala.Float])(implicit executionContext: ExecutionContext): async.Float = new async.Float(in)
}
