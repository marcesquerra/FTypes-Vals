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

    def toFByte: async.Byte = op(async.Byte, _.toByte)
    def toFShort: async.Short = op(async.Short, _.toShort)
    def toFChar: async.Char = op(async.Char, _.toChar)
    def toFInt: async.Int = op(async.Int, _.toInt)
    def toFLong: FLong = this
    def toFFloat: async.Float = op(async.Float, _.toFloat)
    def toFDouble: async.Double = op(async.Double, _.toDouble)

    def unary_~ : FLong = op(FLong, _.unary_~ )
    def unary_+ : FLong = op(FLong, _.unary_+ )
    def unary_- : FLong = op(FLong, _.unary_- )

    def <<(x: async.Int): FLong = op(FLong)(x)(_ << _)
    def <<(x: FLong): FLong = op(FLong)(x)(_ << _)
    def >>>(x: async.Int): FLong = op(FLong)(x)(_ >>> _)
    def >>>(x: FLong): FLong = op(FLong)(x)(_ >>> _)
    def >>(x: async.Int): FLong = op(FLong)(x)(_ >> _)
    def >>(x: FLong): FLong = op(FLong)(x)(_ >> _)

    def ==(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: FLong): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ == _)

    def !=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ != _)

    def <(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: FLong): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ < _)

    def <=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ <= _)

    def >(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: FLong): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ > _)

    def >=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: FLong): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ >= _)

    def |(x: async.Byte): FLong = op(FLong)(x)(_ | _)
    def |(x: async.Short): FLong = op(FLong)(x)(_ | _)
    def |(x: async.Char): FLong = op(FLong)(x)(_ | _)
    def |(x: async.Int): FLong = op(FLong)(x)(_ | _)
    def |(x: FLong): FLong = op(FLong)(x)(_ | _)

    def &(x: async.Byte): FLong = op(FLong)(x)(_ & _)
    def &(x: async.Short): FLong = op(FLong)(x)(_ & _)
    def &(x: async.Char): FLong = op(FLong)(x)(_ & _)
    def &(x: async.Int): FLong = op(FLong)(x)(_ & _)
    def &(x: FLong): FLong = op(FLong)(x)(_ & _)

    def ^(x: async.Byte): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: async.Short): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: async.Char): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: async.Int): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: FLong): FLong = op(FLong)(x)(_ ^ _)

    def +(x: async.Byte): FLong = op(FLong)(x)(_ + _)
    def +(x: async.Short): FLong = op(FLong)(x)(_ + _)
    def +(x: async.Char): FLong = op(FLong)(x)(_ + _)
    def +(x: async.Int): FLong = op(FLong)(x)(_ + _)
    def +(x: FLong): FLong = op(FLong)(x)(_ + _)
    def +(x: async.Float): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Double): async.Double = op(async.Double)(x)(_ + _)

    def -(x: async.Byte): FLong = op(FLong)(x)(_ - _)
    def -(x: async.Short): FLong = op(FLong)(x)(_ - _)
    def -(x: async.Char): FLong = op(FLong)(x)(_ - _)
    def -(x: async.Int): FLong = op(FLong)(x)(_ - _)
    def -(x: FLong): FLong = op(FLong)(x)(_ - _)
    def -(x: async.Float): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Double): async.Double = op(async.Double)(x)(_ - _)

    def *(x: async.Byte): FLong = op(FLong)(x)(_ * _)
    def *(x: async.Short): FLong = op(FLong)(x)(_ * _)
    def *(x: async.Char): FLong = op(FLong)(x)(_ * _)
    def *(x: async.Int): FLong = op(FLong)(x)(_ * _)
    def *(x: FLong): FLong = op(FLong)(x)(_ * _)
    def *(x: async.Float): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Double): async.Double = op(async.Double)(x)(_ * _)

    def /(x: async.Byte): FLong = op(FLong)(x)(_ / _)
    def /(x: async.Short): FLong = op(FLong)(x)(_ / _)
    def /(x: async.Char): FLong = op(FLong)(x)(_ / _)
    def /(x: async.Int): FLong = op(FLong)(x)(_ / _)
    def /(x: FLong): FLong = op(FLong)(x)(_ / _)
    def /(x: async.Float): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Double): async.Double = op(async.Double)(x)(_ / _)

    def %(x: async.Byte): FLong = op(FLong)(x)(_ % _)
    def %(x: async.Short): FLong = op(FLong)(x)(_ % _)
    def %(x: async.Char): FLong = op(FLong)(x)(_ % _)
    def %(x: async.Int): FLong = op(FLong)(x)(_ % _)
    def %(x: FLong): FLong = op(FLong)(x)(_ % _)
    def %(x: async.Float): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Double): async.Double = op(async.Double)(x)(_ % _)
}

object FLong extends async.AnyCompanion[scala.Long, FLong] {
    override def apply(in: Future[scala.Long])(implicit executionContext: ExecutionContext): FLong = new FLong(in)
}
