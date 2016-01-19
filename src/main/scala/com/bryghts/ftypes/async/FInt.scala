package com.bryghts.ftypes.async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FInt(val future: Future[Int])(override implicit protected val executionContext: ExecutionContext) extends FAny[Int, FInt]{

    def op[R, FR <: FAny[R, FR], B](r: FAnyCompanion[R, FR])(fb: FAny[B, _])(f: (Int, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: FAny[R, FR]](r: FAnyCompanion[R, FR], f: Int => R): FR =
        r(future.map(f))

    def toFByte: FByte = op(FByte, _.toByte)
    def toFShort: FShort = op(FShort, _.toShort)
    def toFChar: FChar = op(FChar, _.toChar)
    def toFInt: FInt = this
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

object FInt extends FAnyCompanion[Int, FInt] {
    override def apply(in: Future[Int])(implicit executionContext: ExecutionContext): FInt = new FInt(in)
}
