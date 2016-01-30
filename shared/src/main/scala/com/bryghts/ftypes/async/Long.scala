package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}
import scala.language.implicitConversions

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Long(override          val future: Future[scala.Long])
          (override implicit val executionContext: ExecutionContext) extends async.AnyBase[scala.Long, async.Long]{

    @inline def op[R, FR <: async.AnyBase[R, FR], B](r: async.Builder[R, FR])(fb: async.AnyBase[B, _])(f: (scala.Long, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    @inline def op[R, FR <: async.AnyBase[R, FR]](r: async.Builder[R, FR], f: scala.Long => R): FR =
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


object Long extends Builder[scala.Long, async.Long]{

    implicit val from = Builder[scala.Long, async.Long]{(f, ec) => new async.Long(f)(ec)}

    implicit def implicitLongToAsyncLong (v: scala.Long)    (implicit executionContext: ExecutionContext): async.Long  =
        async.Long from v

    override def apply(in: Future[scala.Long])(implicit executionContext: ExecutionContext): async.Long =
        new async.Long(in)

}
