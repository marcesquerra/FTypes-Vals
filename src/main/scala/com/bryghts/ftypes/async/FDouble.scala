package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FDouble(val future: Future[scala.Double])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Double, FDouble]{

    def op[R, FR <: async.Any[R, FR], B](r: async.AnyCompanion[R, FR])(fb: async.Any[B, _])(f: (scala.Double, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: async.Any[R, FR]](r: async.AnyCompanion[R, FR], f: scala.Double => R): FR =
        r(future.map(f))

    def toFByte: FByte = op(FByte, _.toByte)
    def toFShort: FShort = op(FShort, _.toShort)
    def toFChar: FChar = op(FChar, _.toChar)
    def toFInt: FInt = op(FInt, _.toInt)
    def toFLong: FLong = op(FLong, _.toLong)
    def toFFloat: FFloat = op(FFloat, _.toFloat)
    def toFDouble: FDouble = this

    def unary_+ : FDouble = op(FDouble, _.unary_+ )
    def unary_- : FDouble = op(FDouble, _.unary_- )

    def ==(x: FByte): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FShort): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FChar): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FInt): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FLong): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ == _)

    def !=(x: FByte): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FChar): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ != _)

    def <(x: FByte): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FShort): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FChar): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FInt): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FLong): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ < _)

    def <=(x: FByte): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FChar): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ <= _)

    def >(x: FByte): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FShort): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FChar): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FInt): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FLong): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ > _)

    def >=(x: FByte): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FChar): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ >= _)

    def +(x: FByte): FDouble = op(FDouble)(x)(_ + _)
    def +(x: FShort): FDouble = op(FDouble)(x)(_ + _)
    def +(x: FChar): FDouble = op(FDouble)(x)(_ + _)
    def +(x: FInt): FDouble = op(FDouble)(x)(_ + _)
    def +(x: FLong): FDouble = op(FDouble)(x)(_ + _)
    def +(x: FFloat): FDouble = op(FDouble)(x)(_ + _)
    def +(x: FDouble): FDouble = op(FDouble)(x)(_ + _)

    def -(x: FByte): FDouble = op(FDouble)(x)(_ - _)
    def -(x: FShort): FDouble = op(FDouble)(x)(_ - _)
    def -(x: FChar): FDouble = op(FDouble)(x)(_ - _)
    def -(x: FInt): FDouble = op(FDouble)(x)(_ - _)
    def -(x: FLong): FDouble = op(FDouble)(x)(_ - _)
    def -(x: FFloat): FDouble = op(FDouble)(x)(_ - _)
    def -(x: FDouble): FDouble = op(FDouble)(x)(_ - _)

    def *(x: FByte): FDouble = op(FDouble)(x)(_ * _)
    def *(x: FShort): FDouble = op(FDouble)(x)(_ * _)
    def *(x: FChar): FDouble = op(FDouble)(x)(_ * _)
    def *(x: FInt): FDouble = op(FDouble)(x)(_ * _)
    def *(x: FLong): FDouble = op(FDouble)(x)(_ * _)
    def *(x: FFloat): FDouble = op(FDouble)(x)(_ * _)
    def *(x: FDouble): FDouble = op(FDouble)(x)(_ * _)

    def /(x: FByte): FDouble = op(FDouble)(x)(_ / _)
    def /(x: FShort): FDouble = op(FDouble)(x)(_ / _)
    def /(x: FChar): FDouble = op(FDouble)(x)(_ / _)
    def /(x: FInt): FDouble = op(FDouble)(x)(_ / _)
    def /(x: FLong): FDouble = op(FDouble)(x)(_ / _)
    def /(x: FFloat): FDouble = op(FDouble)(x)(_ / _)
    def /(x: FDouble): FDouble = op(FDouble)(x)(_ / _)

    def %(x: FByte): FDouble = op(FDouble)(x)(_ % _)
    def %(x: FShort): FDouble = op(FDouble)(x)(_ % _)
    def %(x: FChar): FDouble = op(FDouble)(x)(_ % _)
    def %(x: FInt): FDouble = op(FDouble)(x)(_ % _)
    def %(x: FLong): FDouble = op(FDouble)(x)(_ % _)
    def %(x: FFloat): FDouble = op(FDouble)(x)(_ % _)
    def %(x: FDouble): FDouble = op(FDouble)(x)(_ % _)
}

object FDouble extends async.AnyCompanion[scala.Double, FDouble] {
    override def apply(in: Future[scala.Double])(implicit executionContext: ExecutionContext): FDouble = new FDouble(in)
}
