package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}
import scala.language.implicitConversions

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class Byte(override          val future: Future[scala.Byte])
          (override implicit val executionContext: ExecutionContext) extends async.AnyBase[scala.Byte, async.Byte]{

    @inline private def op[R, FR <: async.AnyBase[R, FR], B](r: async.Builder[R, FR])(fb: async.AnyBase[B, _])(f: (scala.Byte, B) => R): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    @inline private def op[R, FR <: async.AnyBase[R, FR]](r: async.Builder[R, FR], f: scala.Byte => R): FR =
        r(future.map(f))

    def toFByte  : async.Byte   = this
    def toFShort : async.Short  = op(async.Short,  _.toShort  )
    def toFChar  : async.Char   = op(async.Char,   _.toChar   )
    def toFInt   : async.Int    = op(async.Int,    _.toInt    )
    def toFLong  : async.Long   = op(async.Long,   _.toLong   )
    def toFFloat : async.Float  = op(async.Float,  _.toFloat  )
    def toFDouble: async.Double = op(async.Double, _.toDouble )

    def unary_~  : async.Int    = op(async.Int,    _.unary_~  )
    def unary_+  : async.Int    = op(async.Int,    _.unary_+  )
    def unary_-  : async.Int    = op(async.Int,    _.unary_-  )

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



object Byte extends Builder[scala.Byte, async.Byte]{

    implicit val from = Builder[scala.Byte, async.Byte]{(f, ec) => new async.Byte(f)(ec)}

    implicit def implicitByteToAsyncByte (v: scala.Byte)    (implicit executionContext: ExecutionContext): async.Byte  =
        async.Byte from v

    override def apply(in: Future[scala.Byte])(implicit executionContext: ExecutionContext): async.Byte =
        new async.Byte(in)

}
