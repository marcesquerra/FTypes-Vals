package com.bryghts.ftypes.async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FShort(val future: Future[Short])(override implicit protected val executionContext: ExecutionContext) extends Any[Short, FShort]{

    def op[R, FR <: Any[R, FR], B](r: FAnyCompanion[R, FR])(fb: Any[B, _])(f: (Short, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: Any[R, FR]](r: FAnyCompanion[R, FR], f: Short => R): FR =
        r(future.map(f))

    def toFByte: FByte = op(FByte, _.toByte)
    def toFShort: FShort = this
    def toFChar: FChar = op(FChar, _.toChar)
    def toFInt: FInt = op(FInt, _.toInt)
    def toFLong: FLong = op(FLong, _.toLong)
    def toFFloat: FFloat = op(FFloat, _.toFloat)
    def toFDouble: FDouble = op(FDouble, _.toDouble)

    def unary_~ : FInt = op(FInt, _.unary_~ )
    def unary_+ : FInt = op(FInt, _.unary_+ )
    def unary_- : FInt = op(FInt, _.unary_- )


    def <<(x: FInt): FInt = op(FInt)(x)(_ << _)
    def <<(x: FLong): FInt = op(FInt)(x)(_ << _)
    def >>>(x: FInt): FInt = op(FInt)(x)(_ >>> _)
    def >>>(x: FLong): FInt = op(FInt)(x)(_ >>> _)
    def >>(x: FInt): FInt = op(FInt)(x)(_ >> _)
    def >>(x: FLong): FInt = op(FInt)(x)(_ >> _)

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

    def |(x: FByte): FInt = op(FInt)(x)(_ | _)
    def |(x: FShort): FInt = op(FInt)(x)(_ | _)
    def |(x: FChar): FInt = op(FInt)(x)(_ | _)
    def |(x: FInt): FInt = op(FInt)(x)(_ | _)
    def |(x: FLong): FLong = op(FLong)(x)(_ | _)

    def &(x: FByte): FInt = op(FInt)(x)(_ & _)
    def &(x: FShort): FInt = op(FInt)(x)(_ & _)
    def &(x: FChar): FInt = op(FInt)(x)(_ & _)
    def &(x: FInt): FInt = op(FInt)(x)(_ & _)
    def &(x: FLong): FLong = op(FLong)(x)(_ & _)

    def ^(x: FByte): FInt = op(FInt)(x)(_ ^ _)
    def ^(x: FShort): FInt = op(FInt)(x)(_ ^ _)
    def ^(x: FChar): FInt = op(FInt)(x)(_ ^ _)
    def ^(x: FInt): FInt = op(FInt)(x)(_ ^ _)
    def ^(x: FLong): FLong = op(FLong)(x)(_ ^ _)

    def +(x: FByte): FInt = op(FInt)(x)(_ + _)
    def +(x: FShort): FInt = op(FInt)(x)(_ + _)
    def +(x: FChar): FInt = op(FInt)(x)(_ + _)
    def +(x: FInt): FInt = op(FInt)(x)(_ + _)
    def +(x: FLong): FLong = op(FLong)(x)(_ + _)
    def +(x: FFloat): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FDouble): FDouble = op(FDouble)(x)(_ + _)

    def -(x: FByte): FInt = op(FInt)(x)(_ - _)
    def -(x: FShort): FInt = op(FInt)(x)(_ - _)
    def -(x: FChar): FInt = op(FInt)(x)(_ - _)
    def -(x: FInt): FInt = op(FInt)(x)(_ - _)
    def -(x: FLong): FLong = op(FLong)(x)(_ - _)
    def -(x: FFloat): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FDouble): FDouble = op(FDouble)(x)(_ - _)

    def *(x: FByte): FInt = op(FInt)(x)(_ * _)
    def *(x: FShort): FInt = op(FInt)(x)(_ * _)
    def *(x: FChar): FInt = op(FInt)(x)(_ * _)
    def *(x: FInt): FInt = op(FInt)(x)(_ * _)
    def *(x: FLong): FLong = op(FLong)(x)(_ * _)
    def *(x: FFloat): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FDouble): FDouble = op(FDouble)(x)(_ * _)

    def /(x: FByte): FInt = op(FInt)(x)(_ / _)
    def /(x: FShort): FInt = op(FInt)(x)(_ / _)
    def /(x: FChar): FInt = op(FInt)(x)(_ / _)
    def /(x: FInt): FInt = op(FInt)(x)(_ / _)
    def /(x: FLong): FLong = op(FLong)(x)(_ / _)
    def /(x: FFloat): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FDouble): FDouble = op(FDouble)(x)(_ / _)

    def %(x: FByte): FInt = op(FInt)(x)(_ % _)
    def %(x: FShort): FInt = op(FInt)(x)(_ % _)
    def %(x: FChar): FInt = op(FInt)(x)(_ % _)
    def %(x: FInt): FInt = op(FInt)(x)(_ % _)
    def %(x: FLong): FLong = op(FLong)(x)(_ % _)
    def %(x: FFloat): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FDouble): FDouble = op(FDouble)(x)(_ % _)
}
object FShort extends FAnyCompanion[Short, FShort] {
    override def apply(in: Future[Short])(implicit executionContext: ExecutionContext): FShort = new FShort(in)
}
