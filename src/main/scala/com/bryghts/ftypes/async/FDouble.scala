package com.bryghts.ftypes.async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FDouble(val future: Future[Double])(override implicit protected val executionContext: ExecutionContext) extends FAny[Double, FDouble]{

    def op[R, FR <: FAny[R, FR], B](r: FAnyCompanion[R, FR])(fb: FAny[B, _])(f: (Double, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: FAny[R, FR]](r: FAnyCompanion[R, FR], f: Double => R): FR =
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

    def ==(x: FByte): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FShort): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FChar): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FInt): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FLong): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FFloat): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FDouble): FBoolean = op(FBoolean)(x)(_ == _)

    def !=(x: FByte): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FShort): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FChar): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FInt): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FLong): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FFloat): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FDouble): FBoolean = op(FBoolean)(x)(_ != _)

    def <(x: FByte): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FShort): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FChar): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FInt): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FLong): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FFloat): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FDouble): FBoolean = op(FBoolean)(x)(_ < _)

    def <=(x: FByte): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FShort): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FChar): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FInt): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FLong): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FFloat): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FDouble): FBoolean = op(FBoolean)(x)(_ <= _)

    def >(x: FByte): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FShort): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FChar): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FInt): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FLong): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FFloat): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FDouble): FBoolean = op(FBoolean)(x)(_ > _)

    def >=(x: FByte): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FShort): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FChar): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FInt): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FLong): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FFloat): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FDouble): FBoolean = op(FBoolean)(x)(_ >= _)

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

object FDouble extends FAnyCompanion[Double, FDouble] {
    override def apply(in: Future[Double])(implicit executionContext: ExecutionContext): FDouble = new FDouble(in)
}
