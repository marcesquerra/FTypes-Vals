package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Long(val future: Future[scala.Long])(override implicit protected val executionContext: ExecutionContext) extends async.Any[scala.Long, async.Long]{

    def op[R, FR <: async.Any[R, FR], B](r: async.AnyCompanion[R, FR])(fb: async.Any[B, _])(f: (scala.Long, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: async.Any[R, FR]](r: async.AnyCompanion[R, FR], f: scala.Long => R): FR =
        r(future.map(f))

    def toFByte: async.Byte = op(async.Byte, _.toByte)
    def toFShort: async.Short = op(async.Short, _.toShort)
    def toFChar: async.Char = op(async.Char, _.toChar)
    def toFInt: async.Int = op(async.Int, _.toInt)
    def toFLong: async.Long = this
    def toFFloat: async.Float = op(async.Float, _.toFloat)
    def toFDouble: async.Double = op(async.Double, _.toDouble)

    def unary_~ : async.Long = op(async.Long, _.unary_~ )
    def unary_+ : async.Long = op(async.Long, _.unary_+ )
    def unary_- : async.Long = op(async.Long, _.unary_- )

    def <<(x: async.Int): async.Long = op(async.Long)(x)(_ << _)
    def <<(x: async.Long): async.Long = op(async.Long)(x)(_ << _)
    def >>>(x: async.Int): async.Long = op(async.Long)(x)(_ >>> _)
    def >>>(x: async.Long): async.Long = op(async.Long)(x)(_ >>> _)
    def >>(x: async.Int): async.Long = op(async.Long)(x)(_ >> _)
    def >>(x: async.Long): async.Long = op(async.Long)(x)(_ >> _)

    def ==(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ == _)
    def ==(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ == _)

    def !=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ != _)
    def !=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ != _)

    def <(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ < _)
    def <(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ < _)

    def <=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ <= _)
    def <=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ <= _)

    def >(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ > _)
    def >(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ > _)

    def >=(x: async.Byte): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Short): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Char): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Int): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Long): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Float): async.Boolean = op(async.Boolean)(x)(_ >= _)
    def >=(x: async.Double): async.Boolean = op(async.Boolean)(x)(_ >= _)

    def |(x: async.Byte): async.Long = op(async.Long)(x)(_ | _)
    def |(x: async.Short): async.Long = op(async.Long)(x)(_ | _)
    def |(x: async.Char): async.Long = op(async.Long)(x)(_ | _)
    def |(x: async.Int): async.Long = op(async.Long)(x)(_ | _)
    def |(x: async.Long): async.Long = op(async.Long)(x)(_ | _)

    def &(x: async.Byte): async.Long = op(async.Long)(x)(_ & _)
    def &(x: async.Short): async.Long = op(async.Long)(x)(_ & _)
    def &(x: async.Char): async.Long = op(async.Long)(x)(_ & _)
    def &(x: async.Int): async.Long = op(async.Long)(x)(_ & _)
    def &(x: async.Long): async.Long = op(async.Long)(x)(_ & _)

    def ^(x: async.Byte): async.Long = op(async.Long)(x)(_ ^ _)
    def ^(x: async.Short): async.Long = op(async.Long)(x)(_ ^ _)
    def ^(x: async.Char): async.Long = op(async.Long)(x)(_ ^ _)
    def ^(x: async.Int): async.Long = op(async.Long)(x)(_ ^ _)
    def ^(x: async.Long): async.Long = op(async.Long)(x)(_ ^ _)

    def +(x: async.Byte): async.Long = op(async.Long)(x)(_ + _)
    def +(x: async.Short): async.Long = op(async.Long)(x)(_ + _)
    def +(x: async.Char): async.Long = op(async.Long)(x)(_ + _)
    def +(x: async.Int): async.Long = op(async.Long)(x)(_ + _)
    def +(x: async.Long): async.Long = op(async.Long)(x)(_ + _)
    def +(x: async.Float): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Double): async.Double = op(async.Double)(x)(_ + _)

    def -(x: async.Byte): async.Long = op(async.Long)(x)(_ - _)
    def -(x: async.Short): async.Long = op(async.Long)(x)(_ - _)
    def -(x: async.Char): async.Long = op(async.Long)(x)(_ - _)
    def -(x: async.Int): async.Long = op(async.Long)(x)(_ - _)
    def -(x: async.Long): async.Long = op(async.Long)(x)(_ - _)
    def -(x: async.Float): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Double): async.Double = op(async.Double)(x)(_ - _)

    def *(x: async.Byte): async.Long = op(async.Long)(x)(_ * _)
    def *(x: async.Short): async.Long = op(async.Long)(x)(_ * _)
    def *(x: async.Char): async.Long = op(async.Long)(x)(_ * _)
    def *(x: async.Int): async.Long = op(async.Long)(x)(_ * _)
    def *(x: async.Long): async.Long = op(async.Long)(x)(_ * _)
    def *(x: async.Float): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Double): async.Double = op(async.Double)(x)(_ * _)

    def /(x: async.Byte): async.Long = op(async.Long)(x)(_ / _)
    def /(x: async.Short): async.Long = op(async.Long)(x)(_ / _)
    def /(x: async.Char): async.Long = op(async.Long)(x)(_ / _)
    def /(x: async.Int): async.Long = op(async.Long)(x)(_ / _)
    def /(x: async.Long): async.Long = op(async.Long)(x)(_ / _)
    def /(x: async.Float): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Double): async.Double = op(async.Double)(x)(_ / _)

    def %(x: async.Byte): async.Long = op(async.Long)(x)(_ % _)
    def %(x: async.Short): async.Long = op(async.Long)(x)(_ % _)
    def %(x: async.Char): async.Long = op(async.Long)(x)(_ % _)
    def %(x: async.Int): async.Long = op(async.Long)(x)(_ % _)
    def %(x: async.Long): async.Long = op(async.Long)(x)(_ % _)
    def %(x: async.Float): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Double): async.Double = op(async.Double)(x)(_ % _)
}

object Long extends async.AnyCompanion[scala.Long, async.Long] {
    override def apply(in: Future[scala.Long])(implicit executionContext: ExecutionContext): async.Long = new async.Long(in)
}
