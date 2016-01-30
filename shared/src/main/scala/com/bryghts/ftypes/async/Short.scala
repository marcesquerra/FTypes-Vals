package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Short(override          val future: Future[scala.Short])
           (override implicit val executionContext: ExecutionContext) extends async.AnyBase[scala.Short, async.Short]{

    @inline def op[R, FR <: async.AnyBase[R, FR], B](r: async.Builder[R, FR])(fb: async.AnyBase[B, _])(f: (scala.Short, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    @inline def op[R, FR <: async.AnyBase[R, FR]](r: async.Builder[R, FR], f: scala.Short => R): FR =
        r(future.map(f))

    def toFByte: async.Byte = op(async.Byte, _.toByte)
    def toFShort: async.Short = this
    def toFChar: async.Char = op(async.Char, _.toChar)
    def toFInt: async.Int = op(async.Int, _.toInt)
    def toFLong: async.Long = op(async.Long, _.toLong)
    def toFFloat: async.Float = op(async.Float, _.toFloat)
    def toFDouble: async.Double = op(async.Double, _.toDouble)

    def unary_~ : async.Int = op(async.Int, _.unary_~ )
    def unary_+ : async.Int = op(async.Int, _.unary_+ )
    def unary_- : async.Int = op(async.Int, _.unary_- )


    def <<(x: async.Int): async.Int = op(async.Int)(x)(_ << _)
    def <<(x: async.Long): async.Int = op(async.Int)(x)(_ << _)
    def >>>(x: async.Int): async.Int = op(async.Int)(x)(_ >>> _)
    def >>>(x: async.Long): async.Int = op(async.Int)(x)(_ >>> _)
    def >>(x: async.Int): async.Int = op(async.Int)(x)(_ >> _)
    def >>(x: async.Long): async.Int = op(async.Int)(x)(_ >> _)

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

    def |(x: async.Byte): async.Int = op(async.Int)(x)(_ | _)
    def |(x: async.Short): async.Int = op(async.Int)(x)(_ | _)
    def |(x: async.Char): async.Int = op(async.Int)(x)(_ | _)
    def |(x: async.Int): async.Int = op(async.Int)(x)(_ | _)
    def |(x: async.Long): async.Long = op(async.Long)(x)(_ | _)

    def &(x: async.Byte): async.Int = op(async.Int)(x)(_ & _)
    def &(x: async.Short): async.Int = op(async.Int)(x)(_ & _)
    def &(x: async.Char): async.Int = op(async.Int)(x)(_ & _)
    def &(x: async.Int): async.Int = op(async.Int)(x)(_ & _)
    def &(x: async.Long): async.Long = op(async.Long)(x)(_ & _)

    def ^(x: async.Byte): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: async.Short): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: async.Char): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: async.Int): async.Int = op(async.Int)(x)(_ ^ _)
    def ^(x: async.Long): async.Long = op(async.Long)(x)(_ ^ _)

    def +(x: async.Byte): async.Int = op(async.Int)(x)(_ + _)
    def +(x: async.Short): async.Int = op(async.Int)(x)(_ + _)
    def +(x: async.Char): async.Int = op(async.Int)(x)(_ + _)
    def +(x: async.Int): async.Int = op(async.Int)(x)(_ + _)
    def +(x: async.Long): async.Long = op(async.Long)(x)(_ + _)
    def +(x: async.Float): async.Float = op(async.Float)(x)(_ + _)
    def +(x: async.Double): async.Double = op(async.Double)(x)(_ + _)

    def -(x: async.Byte): async.Int = op(async.Int)(x)(_ - _)
    def -(x: async.Short): async.Int = op(async.Int)(x)(_ - _)
    def -(x: async.Char): async.Int = op(async.Int)(x)(_ - _)
    def -(x: async.Int): async.Int = op(async.Int)(x)(_ - _)
    def -(x: async.Long): async.Long = op(async.Long)(x)(_ - _)
    def -(x: async.Float): async.Float = op(async.Float)(x)(_ - _)
    def -(x: async.Double): async.Double = op(async.Double)(x)(_ - _)

    def *(x: async.Byte): async.Int = op(async.Int)(x)(_ * _)
    def *(x: async.Short): async.Int = op(async.Int)(x)(_ * _)
    def *(x: async.Char): async.Int = op(async.Int)(x)(_ * _)
    def *(x: async.Int): async.Int = op(async.Int)(x)(_ * _)
    def *(x: async.Long): async.Long = op(async.Long)(x)(_ * _)
    def *(x: async.Float): async.Float = op(async.Float)(x)(_ * _)
    def *(x: async.Double): async.Double = op(async.Double)(x)(_ * _)

    def /(x: async.Byte): async.Int = op(async.Int)(x)(_ / _)
    def /(x: async.Short): async.Int = op(async.Int)(x)(_ / _)
    def /(x: async.Char): async.Int = op(async.Int)(x)(_ / _)
    def /(x: async.Int): async.Int = op(async.Int)(x)(_ / _)
    def /(x: async.Long): async.Long = op(async.Long)(x)(_ / _)
    def /(x: async.Float): async.Float = op(async.Float)(x)(_ / _)
    def /(x: async.Double): async.Double = op(async.Double)(x)(_ / _)

    def %(x: async.Byte): async.Int = op(async.Int)(x)(_ % _)
    def %(x: async.Short): async.Int = op(async.Int)(x)(_ % _)
    def %(x: async.Char): async.Int = op(async.Int)(x)(_ % _)
    def %(x: async.Int): async.Int = op(async.Int)(x)(_ % _)
    def %(x: async.Long): async.Long = op(async.Long)(x)(_ % _)
    def %(x: async.Float): async.Float = op(async.Float)(x)(_ % _)
    def %(x: async.Double): async.Double = op(async.Double)(x)(_ % _)
}


object Short extends Builder[scala.Short, async.Short]{

    implicit val from = Builder[scala.Short, async.Short]{(f, ec) => new async.Short(f)(ec)}

    implicit def implicitShortToAsyncShort (v: scala.Short)    (implicit executionContext: ExecutionContext): async.Short  =
        async.Short from v

    override def apply(in: Future[scala.Short])(implicit executionContext: ExecutionContext): async.Short =
        new async.Short(in)

}
