package com.bryghts.ftypes

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FChar(val future: Future[Char])(override implicit protected val executionContext: ExecutionContext) extends FAny[Char, FChar]{

    def op[R, FR <: FAny[R, FR], B](r: FAnyCompanion[R, FR])(fb: FAny[B, _])(f: (Char, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: FAny[R, FR]](r: FAnyCompanion[R, FR], f: Char => R): FR =
        r(future.map(f))

    def toFShort: FShort = op(FShort, _.toShort)
    def toFChar: FChar = this
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
object FChar extends FAnyCompanion[Char, FChar] {
    override def apply(in: Future[Char])(implicit executionContext: ExecutionContext): FChar = new FChar(in)
}
