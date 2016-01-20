package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Int(val future: Future[scala.Int])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Int, async.Int]{

    def op[R, FR <: async.Any[R, FR], B](r: async.AnyCompanion[R, FR])(fb: async.Any[B, _])(f: (scala.Int, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: async.Any[R, FR]](r: async.AnyCompanion[R, FR], f: scala.Int => R): FR =
        r(future.map(f))

    def toFByte: async.Byte = op(async.Byte, _.toByte)
    def toFShort: async.Short = op(async.Short, _.toShort)
    def toFChar: async.Char = op(async.Char, _.toChar)
    def toFInt: async.Int = this
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

    def |(x: async.Byte): async.Int = op(async.Int)(x)(_ | _)
    def |(x: async.Short): async.Int = op(async.Int)(x)(_ | _)
    def |(x: async.Char): async.Int = op(async.Int)(x)(_ | _)
    def |(x: async.Int): async.Int = op(async.Int)(x)(_ | _)
    def |(x: FLong): FLong = op(FLong)(x)(_ | _)

    def &(x: async.Byte): async.Int = op(async.Int)(x)(_ & _)
    def &(x: async.Short): async.Int = op(async.Int)(x)(_ & _)
    def &(x: async.Char): async.Int = op(async.Int)(x)(_ & _)
    def &(x: async.Int): async.Int = op(async.Int)(x)(_ & _)
    def &(x: FLong): FLong = op(FLong)(x)(_ & _)

    def ^(x: async.Byte): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: async.Short): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: async.Char): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: async.Int): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: FLong): FLong = op(FLong)(x)(_ ^ _)

    def +(x: async.Byte): async.Int = op(async.Int)(x)(_ + _)
    def +(x: async.Short): async.Int = op(async.Int)(x)(_ + _)
    def +(x: async.Char): async.Int = op(async.Int)(x)(_ + _)
    def +(x: async.Int): async.Int = op(async.Int)(x)(_ + _)
    def +(x: FLong): FLong = op(FLong)(x)(_ + _)
    def +(x: async.Float): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Double): async.Double = op(async.Double)(x)(_ + _)

    def -(x: async.Byte): async.Int = op(async.Int)(x)(_ - _)
    def -(x: async.Short): async.Int = op(async.Int)(x)(_ - _)
    def -(x: async.Char): async.Int = op(async.Int)(x)(_ - _)
    def -(x: async.Int): async.Int = op(async.Int)(x)(_ - _)
    def -(x: FLong): FLong = op(FLong)(x)(_ - _)
    def -(x: async.Float): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Double): async.Double = op(async.Double)(x)(_ - _)

    def *(x: async.Byte): async.Int = op(async.Int)(x)(_ * _)
    def *(x: async.Short): async.Int = op(async.Int)(x)(_ * _)
    def *(x: async.Char): async.Int = op(async.Int)(x)(_ * _)
    def *(x: async.Int): async.Int = op(async.Int)(x)(_ * _)
    def *(x: FLong): FLong = op(FLong)(x)(_ * _)
    def *(x: async.Float): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Double): async.Double = op(async.Double)(x)(_ * _)

    def /(x: async.Byte): async.Int = op(async.Int)(x)(_ / _)
    def /(x: async.Short): async.Int = op(async.Int)(x)(_ / _)
    def /(x: async.Char): async.Int = op(async.Int)(x)(_ / _)
    def /(x: async.Int): async.Int = op(async.Int)(x)(_ / _)
    def /(x: FLong): FLong = op(FLong)(x)(_ / _)
    def /(x: async.Float): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Double): async.Double = op(async.Double)(x)(_ / _)

    def %(x: async.Byte): async.Int = op(async.Int)(x)(_ % _)
    def %(x: async.Short): async.Int = op(async.Int)(x)(_ % _)
    def %(x: async.Char): async.Int = op(async.Int)(x)(_ % _)
    def %(x: async.Int): async.Int = op(async.Int)(x)(_ % _)
    def %(x: FLong): FLong = op(FLong)(x)(_ % _)
    def %(x: async.Float): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Double): async.Double = op(async.Double)(x)(_ % _)
}

object Int extends async.AnyCompanion[scala.Int, async.Int] {
    override def apply(in: Future[scala.Int])(implicit executionContext: ExecutionContext): async.Int = new async.Int(in)
}
