package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Char(val future: Future[scala.Char])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Char, async.Char]{

    def op[R, FR <: async.Any[R, FR], B](r: async.AnyCompanion[R, FR])(fb: async.Any[B, _])(f: (scala.Char, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: async.Any[R, FR]](r: async.AnyCompanion[R, FR], f: scala.Char => R): FR =
        r(future.map(f))

    def toFShort: FShort = op(FShort, _.toShort)
    def toFChar: async.Char = this
    def toFInt: async.Int = op(async.Int, _.toInt)
    def toFLong: FLong = op(FLong, _.toLong)
    def toFFloat: async.Float = op(async.Float, _.toFloat)
    def toFDouble: async.Double = op(async.Double, _.toDouble)

    def unary_~ : async.Int = op(async.Int, _.unary_~ )
    def unary_+ : async.Int = op(async.Int, _.unary_+ )
    def unary_- : async.Int = op(async.Int, _.unary_- )

    def <<(x: async.Int): async.Int = op(async.Int)(x)(_ << _)
    def <<(x: FLong): async.Int = op(async.Int)(x)(_ << _)
    def >>>(x: async.Int): async.Int = op(async.Int)(x)(_ >>> _)
    def >>>(x: FLong): async.Int = op(async.Int)(x)(_ >>> _)
    def >>(x: async.Int): async.Int = op(async.Int)(x)(_ >> _)
    def >>(x: FLong): async.Int = op(async.Int)(x)(_ >> _)

    def ==(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FShort): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FLong): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ == _)

    def !=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ != _)

    def <(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FShort): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FLong): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ < _)

    def <=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ <= _)

    def >(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FShort): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FLong): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ > _)

    def >=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FShort): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ >= _)

    def |(x: async.Byte): async.Int = op(async.Int)(x)(_ | _)
    def |(x: FShort): async.Int = op(async.Int)(x)(_ | _)
    def |(x: async.Char): async.Int = op(async.Int)(x)(_ | _)
    def |(x: async.Int): async.Int = op(async.Int)(x)(_ | _)
    def |(x: FLong): FLong = op(FLong)(x)(_ | _)

    def &(x: async.Byte): async.Int = op(async.Int)(x)(_ & _)
    def &(x: FShort): async.Int = op(async.Int)(x)(_ & _)
    def &(x: async.Char): async.Int = op(async.Int)(x)(_ & _)
    def &(x: async.Int): async.Int = op(async.Int)(x)(_ & _)
    def &(x: FLong): FLong = op(FLong)(x)(_ & _)

    def ^(x: async.Byte): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: FShort): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: async.Char): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: async.Int): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: FLong): FLong = op(FLong)(x)(_ ^ _)

    def +(x: async.Byte): async.Int = op(async.Int)(x)(_ + _)
    def +(x: FShort): async.Int = op(async.Int)(x)(_ + _)
    def +(x: async.Char): async.Int = op(async.Int)(x)(_ + _)
    def +(x: async.Int): async.Int = op(async.Int)(x)(_ + _)
    def +(x: FLong): FLong = op(FLong)(x)(_ + _)
    def +(x: async.Float): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Double): async.Double = op(async.Double)(x)(_ + _)

    def -(x: async.Byte): async.Int = op(async.Int)(x)(_ - _)
    def -(x: FShort): async.Int = op(async.Int)(x)(_ - _)
    def -(x: async.Char): async.Int = op(async.Int)(x)(_ - _)
    def -(x: async.Int): async.Int = op(async.Int)(x)(_ - _)
    def -(x: FLong): FLong = op(FLong)(x)(_ - _)
    def -(x: async.Float): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Double): async.Double = op(async.Double)(x)(_ - _)

    def *(x: async.Byte): async.Int = op(async.Int)(x)(_ * _)
    def *(x: FShort): async.Int = op(async.Int)(x)(_ * _)
    def *(x: async.Char): async.Int = op(async.Int)(x)(_ * _)
    def *(x: async.Int): async.Int = op(async.Int)(x)(_ * _)
    def *(x: FLong): FLong = op(FLong)(x)(_ * _)
    def *(x: async.Float): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Double): async.Double = op(async.Double)(x)(_ * _)

    def /(x: async.Byte): async.Int = op(async.Int)(x)(_ / _)
    def /(x: FShort): async.Int = op(async.Int)(x)(_ / _)
    def /(x: async.Char): async.Int = op(async.Int)(x)(_ / _)
    def /(x: async.Int): async.Int = op(async.Int)(x)(_ / _)
    def /(x: FLong): FLong = op(FLong)(x)(_ / _)
    def /(x: async.Float): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Double): async.Double = op(async.Double)(x)(_ / _)

    def %(x: async.Byte): async.Int = op(async.Int)(x)(_ % _)
    def %(x: FShort): async.Int = op(async.Int)(x)(_ % _)
    def %(x: async.Char): async.Int = op(async.Int)(x)(_ % _)
    def %(x: async.Int): async.Int = op(async.Int)(x)(_ % _)
    def %(x: FLong): FLong = op(FLong)(x)(_ % _)
    def %(x: async.Float): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Double): async.Double = op(async.Double)(x)(_ % _)
}
object Char extends async.AnyCompanion[scala.Char, async.Char] {
    override def apply(in: Future[scala.Char])(implicit executionContext: ExecutionContext): async.Char = new async.Char(in)
}
