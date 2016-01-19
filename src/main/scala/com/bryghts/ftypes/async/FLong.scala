package com.bryghts.ftypes.async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FLong(val future: Future[Long])(override implicit protected val executionContext: ExecutionContext) extends Any[Long, FLong]{

    def op[R, FR <: Any[R, FR], B](r: FAnyCompanion[R, FR])(fb: Any[B, _])(f: (Long, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: Any[R, FR]](r: FAnyCompanion[R, FR], f: Long => R): FR =
        r(future.map(f))

    def toFByte: FByte = op(FByte, _.toByte)
    def toFShort: FShort = op(FShort, _.toShort)
    def toFChar: FChar = op(FChar, _.toChar)
    def toFInt: FInt = op(FInt, _.toInt)
    def toFLong: FLong = this
    def toFFloat: FFloat = op(FFloat, _.toFloat)
    def toFDouble: FDouble = op(FDouble, _.toDouble)

    def unary_~ : FLong = op(FLong, _.unary_~ )
    def unary_+ : FLong = op(FLong, _.unary_+ )
    def unary_- : FLong = op(FLong, _.unary_- )

    def <<(x: FInt): FLong = op(FLong)(x)(_ << _)
    def <<(x: FLong): FLong = op(FLong)(x)(_ << _)
    def >>>(x: FInt): FLong = op(FLong)(x)(_ >>> _)
    def >>>(x: FLong): FLong = op(FLong)(x)(_ >>> _)
    def >>(x: FInt): FLong = op(FLong)(x)(_ >> _)
    def >>(x: FLong): FLong = op(FLong)(x)(_ >> _)

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

    def |(x: FByte): FLong = op(FLong)(x)(_ | _)
    def |(x: FShort): FLong = op(FLong)(x)(_ | _)
    def |(x: FChar): FLong = op(FLong)(x)(_ | _)
    def |(x: FInt): FLong = op(FLong)(x)(_ | _)
    def |(x: FLong): FLong = op(FLong)(x)(_ | _)

    def &(x: FByte): FLong = op(FLong)(x)(_ & _)
    def &(x: FShort): FLong = op(FLong)(x)(_ & _)
    def &(x: FChar): FLong = op(FLong)(x)(_ & _)
    def &(x: FInt): FLong = op(FLong)(x)(_ & _)
    def &(x: FLong): FLong = op(FLong)(x)(_ & _)

    def ^(x: FByte): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: FShort): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: FChar): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: FInt): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: FLong): FLong = op(FLong)(x)(_ ^ _)

    def +(x: FByte): FLong = op(FLong)(x)(_ + _)
    def +(x: FShort): FLong = op(FLong)(x)(_ + _)
    def +(x: FChar): FLong = op(FLong)(x)(_ + _)
    def +(x: FInt): FLong = op(FLong)(x)(_ + _)
    def +(x: FLong): FLong = op(FLong)(x)(_ + _)
    def +(x: FFloat): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FDouble): FDouble = op(FDouble)(x)(_ + _)

    def -(x: FByte): FLong = op(FLong)(x)(_ - _)
    def -(x: FShort): FLong = op(FLong)(x)(_ - _)
    def -(x: FChar): FLong = op(FLong)(x)(_ - _)
    def -(x: FInt): FLong = op(FLong)(x)(_ - _)
    def -(x: FLong): FLong = op(FLong)(x)(_ - _)
    def -(x: FFloat): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FDouble): FDouble = op(FDouble)(x)(_ - _)

    def *(x: FByte): FLong = op(FLong)(x)(_ * _)
    def *(x: FShort): FLong = op(FLong)(x)(_ * _)
    def *(x: FChar): FLong = op(FLong)(x)(_ * _)
    def *(x: FInt): FLong = op(FLong)(x)(_ * _)
    def *(x: FLong): FLong = op(FLong)(x)(_ * _)
    def *(x: FFloat): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FDouble): FDouble = op(FDouble)(x)(_ * _)

    def /(x: FByte): FLong = op(FLong)(x)(_ / _)
    def /(x: FShort): FLong = op(FLong)(x)(_ / _)
    def /(x: FChar): FLong = op(FLong)(x)(_ / _)
    def /(x: FInt): FLong = op(FLong)(x)(_ / _)
    def /(x: FLong): FLong = op(FLong)(x)(_ / _)
    def /(x: FFloat): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FDouble): FDouble = op(FDouble)(x)(_ / _)

    def %(x: FByte): FLong = op(FLong)(x)(_ % _)
    def %(x: FShort): FLong = op(FLong)(x)(_ % _)
    def %(x: FChar): FLong = op(FLong)(x)(_ % _)
    def %(x: FInt): FLong = op(FLong)(x)(_ % _)
    def %(x: FLong): FLong = op(FLong)(x)(_ % _)
    def %(x: FFloat): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FDouble): FDouble = op(FDouble)(x)(_ % _)
}

object FLong extends FAnyCompanion[Long, FLong] {
    override def apply(in: Future[Long])(implicit executionContext: ExecutionContext): FLong = new FLong(in)
}
