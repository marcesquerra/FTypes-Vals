package com.bryghts.ftypes.async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FFloat(val future: Future[Float])(override implicit protected val executionContext: ExecutionContext) extends Any[Float, FFloat]{

    def op[R, FR <: Any[R, FR], B](r: AnyCompanion[R, FR])(fb: Any[B, _])(f: (Float, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: Any[R, FR]](r: AnyCompanion[R, FR], f: Float => R): FR =
        r(future.map(f))

    def toFByte: FByte = op(FByte, _.toByte)
    def toFShort: FShort = op(FShort, _.toShort)
    def toFChar: FChar = op(FChar, _.toChar)
    def toFInt: FInt = op(FInt, _.toInt)
    def toFLong: FLong = op(FLong, _.toLong)
    def toFFloat: FFloat = this
    def toFDouble: FDouble = op(FDouble, _.toDouble)

    def unary_+ : FFloat = op(FFloat, _.unary_+ )
    def unary_- : FFloat = op(FFloat, _.unary_- )

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

    def +(x: FByte): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FShort): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FChar): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FInt): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FLong): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FFloat): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FDouble): FDouble = op(FDouble)(x)(_ + _)

    def -(x: FByte): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FShort): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FChar): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FInt): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FLong): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FFloat): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FDouble): FDouble = op(FDouble)(x)(_ - _)

    def *(x: FByte): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FShort): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FChar): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FInt): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FLong): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FFloat): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FDouble): FDouble = op(FDouble)(x)(_ * _)

    def /(x: FByte): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FShort): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FChar): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FInt): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FLong): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FFloat): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FDouble): FDouble = op(FDouble)(x)(_ / _)

    def %(x: FByte): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FShort): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FChar): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FInt): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FLong): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FFloat): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FDouble): FDouble = op(FDouble)(x)(_ % _)
}

object FFloat extends AnyCompanion[Float, FFloat] {
    override def apply(in: Future[Float])(implicit executionContext: ExecutionContext): FFloat = new FFloat(in)
}
