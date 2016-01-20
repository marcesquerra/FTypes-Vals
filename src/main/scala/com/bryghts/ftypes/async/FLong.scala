package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FLong(val future: Future[scala.Long])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Long, FLong]{

    def op[R, FR <: async.Any[R, FR], B](r: async.AnyCompanion[R, FR])(fb: async.Any[B, _])(f: (scala.Long, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: async.Any[R, FR]](r: async.AnyCompanion[R, FR], f: scala.Long => R): FR =
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

object FLong extends async.AnyCompanion[scala.Long, FLong] {
    override def apply(in: Future[scala.Long])(implicit executionContext: ExecutionContext): FLong = new FLong(in)
}
