package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Double(val future: Future[scala.Double])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Double, async.Double]{

    def op[R, FR <: async.Any[R, FR], B](r: async.AnyCompanion[R, FR])(fb: async.Any[B, _])(f: (scala.Double, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: async.Any[R, FR]](r: async.AnyCompanion[R, FR], f: scala.Double => R): FR =
        r(future.map(f))

    def toFByte: async.Byte = op(async.Byte, _.toByte)
    def toFShort: FShort = op(FShort, _.toShort)
    def toFChar: async.Char = op(async.Char, _.toChar)
    def toFInt: FInt = op(FInt, _.toInt)
    def toFLong: FLong = op(FLong, _.toLong)
    def toFFloat: FFloat = op(FFloat, _.toFloat)
    def toFDouble: async.Double = this

    def unary_+ : async.Double = op(async.Double, _.unary_+ )
    def unary_- : async.Double = op(async.Double, _.unary_- )

    def ==(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FShort): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FInt): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FLong): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ == _)

    def !=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ != _)

    def <(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FShort): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FInt): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FLong): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ < _)

    def <=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ <= _)

    def >(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FShort): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FInt): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FLong): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ > _)

    def >=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ >= _)

    def +(x: async.Byte): async.Double = op(async.Double)(x)(_ + _)
    def +(x: FShort): async.Double = op(async.Double)(x)(_ + _)
    def +(x: async.Char): async.Double = op(async.Double)(x)(_ + _)
    def +(x: FInt): async.Double = op(async.Double)(x)(_ + _)
    def +(x: FLong): async.Double = op(async.Double)(x)(_ + _)
    def +(x: FFloat): async.Double = op(async.Double)(x)(_ + _)
    def +(x: async.Double): async.Double = op(async.Double)(x)(_ + _)

    def -(x: async.Byte): async.Double = op(async.Double)(x)(_ - _)
    def -(x: FShort): async.Double = op(async.Double)(x)(_ - _)
    def -(x: async.Char): async.Double = op(async.Double)(x)(_ - _)
    def -(x: FInt): async.Double = op(async.Double)(x)(_ - _)
    def -(x: FLong): async.Double = op(async.Double)(x)(_ - _)
    def -(x: FFloat): async.Double = op(async.Double)(x)(_ - _)
    def -(x: async.Double): async.Double = op(async.Double)(x)(_ - _)

    def *(x: async.Byte): async.Double = op(async.Double)(x)(_ * _)
    def *(x: FShort): async.Double = op(async.Double)(x)(_ * _)
    def *(x: async.Char): async.Double = op(async.Double)(x)(_ * _)
    def *(x: FInt): async.Double = op(async.Double)(x)(_ * _)
    def *(x: FLong): async.Double = op(async.Double)(x)(_ * _)
    def *(x: FFloat): async.Double = op(async.Double)(x)(_ * _)
    def *(x: async.Double): async.Double = op(async.Double)(x)(_ * _)

    def /(x: async.Byte): async.Double = op(async.Double)(x)(_ / _)
    def /(x: FShort): async.Double = op(async.Double)(x)(_ / _)
    def /(x: async.Char): async.Double = op(async.Double)(x)(_ / _)
    def /(x: FInt): async.Double = op(async.Double)(x)(_ / _)
    def /(x: FLong): async.Double = op(async.Double)(x)(_ / _)
    def /(x: FFloat): async.Double = op(async.Double)(x)(_ / _)
    def /(x: async.Double): async.Double = op(async.Double)(x)(_ / _)

    def %(x: async.Byte): async.Double = op(async.Double)(x)(_ % _)
    def %(x: FShort): async.Double = op(async.Double)(x)(_ % _)
    def %(x: async.Char): async.Double = op(async.Double)(x)(_ % _)
    def %(x: FInt): async.Double = op(async.Double)(x)(_ % _)
    def %(x: FLong): async.Double = op(async.Double)(x)(_ % _)
    def %(x: FFloat): async.Double = op(async.Double)(x)(_ % _)
    def %(x: async.Double): async.Double = op(async.Double)(x)(_ % _)
}

object Double extends async.AnyCompanion[scala.Double, async.Double] {
    override def apply(in: Future[scala.Double])(implicit executionContext: ExecutionContext): async.Double = new async.Double(in)
}
