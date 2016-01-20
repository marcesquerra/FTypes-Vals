package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FShort(val future: Future[scala.Short])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Short, FShort]{

    def op[R, FR <: async.Any[R, FR], B](r: async.AnyCompanion[R, FR])(fb: async.Any[B, _])(f: (scala.Short, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: async.Any[R, FR]](r: async.AnyCompanion[R, FR], f: scala.Short => R): FR =
        r(future.map(f))

    def toFByte: async.Byte = op(async.Byte, _.toByte)
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

    def ==(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FShort): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FChar): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FInt): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FLong): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ == _)

    def !=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FChar): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ != _)

    def <(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FShort): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FChar): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FInt): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FLong): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ < _)

    def <=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FChar): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ <= _)

    def >(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FShort): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FChar): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FInt): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FLong): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ > _)

    def >=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FChar): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FInt): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FFloat): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FDouble): async.Boolean = op(async.Boolean)(x)(_ >= _)

    def |(x: async.Byte): FInt = op(FInt)(x)(_ | _)
    def |(x: FShort): FInt = op(FInt)(x)(_ | _)
    def |(x: FChar): FInt = op(FInt)(x)(_ | _)
    def |(x: FInt): FInt = op(FInt)(x)(_ | _)
    def |(x: FLong): FLong = op(FLong)(x)(_ | _)

    def &(x: async.Byte): FInt = op(FInt)(x)(_ & _)
    def &(x: FShort): FInt = op(FInt)(x)(_ & _)
    def &(x: FChar): FInt = op(FInt)(x)(_ & _)
    def &(x: FInt): FInt = op(FInt)(x)(_ & _)
    def &(x: FLong): FLong = op(FLong)(x)(_ & _)

    def ^(x: async.Byte): FInt = op(FInt)(x)(_ ^ _)
    def ^(x: FShort): FInt = op(FInt)(x)(_ ^ _)
    def ^(x: FChar): FInt = op(FInt)(x)(_ ^ _)
    def ^(x: FInt): FInt = op(FInt)(x)(_ ^ _)
    def ^(x: FLong): FLong = op(FLong)(x)(_ ^ _)

    def +(x: async.Byte): FInt = op(FInt)(x)(_ + _)
    def +(x: FShort): FInt = op(FInt)(x)(_ + _)
    def +(x: FChar): FInt = op(FInt)(x)(_ + _)
    def +(x: FInt): FInt = op(FInt)(x)(_ + _)
    def +(x: FLong): FLong = op(FLong)(x)(_ + _)
    def +(x: FFloat): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FDouble): FDouble = op(FDouble)(x)(_ + _)

    def -(x: async.Byte): FInt = op(FInt)(x)(_ - _)
    def -(x: FShort): FInt = op(FInt)(x)(_ - _)
    def -(x: FChar): FInt = op(FInt)(x)(_ - _)
    def -(x: FInt): FInt = op(FInt)(x)(_ - _)
    def -(x: FLong): FLong = op(FLong)(x)(_ - _)
    def -(x: FFloat): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FDouble): FDouble = op(FDouble)(x)(_ - _)

    def *(x: async.Byte): FInt = op(FInt)(x)(_ * _)
    def *(x: FShort): FInt = op(FInt)(x)(_ * _)
    def *(x: FChar): FInt = op(FInt)(x)(_ * _)
    def *(x: FInt): FInt = op(FInt)(x)(_ * _)
    def *(x: FLong): FLong = op(FLong)(x)(_ * _)
    def *(x: FFloat): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FDouble): FDouble = op(FDouble)(x)(_ * _)

    def /(x: async.Byte): FInt = op(FInt)(x)(_ / _)
    def /(x: FShort): FInt = op(FInt)(x)(_ / _)
    def /(x: FChar): FInt = op(FInt)(x)(_ / _)
    def /(x: FInt): FInt = op(FInt)(x)(_ / _)
    def /(x: FLong): FLong = op(FLong)(x)(_ / _)
    def /(x: FFloat): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FDouble): FDouble = op(FDouble)(x)(_ / _)

    def %(x: async.Byte): FInt = op(FInt)(x)(_ % _)
    def %(x: FShort): FInt = op(FInt)(x)(_ % _)
    def %(x: FChar): FInt = op(FInt)(x)(_ % _)
    def %(x: FInt): FInt = op(FInt)(x)(_ % _)
    def %(x: FLong): FLong = op(FLong)(x)(_ % _)
    def %(x: FFloat): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FDouble): FDouble = op(FDouble)(x)(_ % _)
}
object FShort extends async.AnyCompanion[scala.Short, FShort] {
    override def apply(in: Future[scala.Short])(implicit executionContext: ExecutionContext): FShort = new FShort(in)
}
