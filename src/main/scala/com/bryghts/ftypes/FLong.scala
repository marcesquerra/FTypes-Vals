package com.bryghts.ftypes

import com.bryghts.ftypes.components.{FBuilder, FAnyCompanion, FAny}

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FLong(val future: Future[Long]) extends FAny[Long, FLong]{

    override protected val builder: FBuilder[Long, FLong] = FLong

    def op[R, FR <: FAny[R, FR], B](r: FAnyCompanion[R, FR])(fb: FAny[B, _])(f: (Long, B) => R)(implicit ec: ExecutionContext): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: FAny[R, FR]](r: FAnyCompanion[R, FR], f: Long => R)(implicit ec: ExecutionContext): FR =
        r(future.map(f))

    def toFByte(implicit ec: ExecutionContext): FByte = op(FByte, _.toByte)
    def toFShort(implicit ec: ExecutionContext): FShort = op(FShort, _.toShort)
    def toFChar(implicit ec: ExecutionContext): FChar = op(FChar, _.toChar)
    def toFInt(implicit ec: ExecutionContext): FInt = op(FInt, _.toInt)
    def toFLong(implicit ec: ExecutionContext): FLong = this
    def toFFloat(implicit ec: ExecutionContext): FFloat = op(FFloat, _.toFloat)
    def toFDouble(implicit ec: ExecutionContext): FDouble = op(FDouble, _.toDouble)

    def unary_~ (implicit ec: ExecutionContext): FLong = op(FLong, _.unary_~ )
    def unary_+ (implicit ec: ExecutionContext): FLong = op(FLong, _.unary_+ )
    def unary_- (implicit ec: ExecutionContext): FLong = op(FLong, _.unary_- )

    def +(x: FString)(implicit ec: ExecutionContext): FString = op(FString)(x)(_ + _)

    def <<(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ << _)
    def <<(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ << _)
    def >>>(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ >>> _)
    def >>>(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ >>> _)
    def >>(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ >> _)
    def >>(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ >> _)

    def ==(x: FByte)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FShort)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FChar)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FLong)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FFloat)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ == _)
    def ==(x: FDouble)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ == _)

    def !=(x: FByte)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FShort)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FChar)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FLong)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FFloat)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ != _)
    def !=(x: FDouble)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ != _)

    def <(x: FByte)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FShort)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FChar)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FLong)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FFloat)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ < _)
    def <(x: FDouble)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ < _)

    def <=(x: FByte)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FShort)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FChar)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FLong)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FFloat)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ <= _)
    def <=(x: FDouble)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ <= _)

    def >(x: FByte)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FShort)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FChar)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FLong)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FFloat)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ > _)
    def >(x: FDouble)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ > _)

    def >=(x: FByte)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FShort)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FChar)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FLong)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FFloat)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ >= _)
    def >=(x: FDouble)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(x)(_ >= _)

    def |(x: FByte)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ | _)
    def |(x: FShort)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ | _)
    def |(x: FChar)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ | _)
    def |(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ | _)
    def |(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ | _)

    def &(x: FByte)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ & _)
    def &(x: FShort)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ & _)
    def &(x: FChar)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ & _)
    def &(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ & _)
    def &(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ & _)

    def ^(x: FByte)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: FShort)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: FChar)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ ^ _)
    def ^(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ ^ _)

    def +(x: FByte)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ + _)
    def +(x: FShort)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ + _)
    def +(x: FChar)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ + _)
    def +(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ + _)
    def +(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ + _)
    def +(x: FFloat)(implicit ec: ExecutionContext): FFloat = op(FFloat)(x)(_ + _)
    def +(x: FDouble)(implicit ec: ExecutionContext): FDouble = op(FDouble)(x)(_ + _)

    def -(x: FByte)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ - _)
    def -(x: FShort)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ - _)
    def -(x: FChar)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ - _)
    def -(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ - _)
    def -(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ - _)
    def -(x: FFloat)(implicit ec: ExecutionContext): FFloat = op(FFloat)(x)(_ - _)
    def -(x: FDouble)(implicit ec: ExecutionContext): FDouble = op(FDouble)(x)(_ - _)

    def *(x: FByte)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ * _)
    def *(x: FShort)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ * _)
    def *(x: FChar)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ * _)
    def *(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ * _)
    def *(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ * _)
    def *(x: FFloat)(implicit ec: ExecutionContext): FFloat = op(FFloat)(x)(_ * _)
    def *(x: FDouble)(implicit ec: ExecutionContext): FDouble = op(FDouble)(x)(_ * _)

    def /(x: FByte)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ / _)
    def /(x: FShort)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ / _)
    def /(x: FChar)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ / _)
    def /(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ / _)
    def /(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ / _)
    def /(x: FFloat)(implicit ec: ExecutionContext): FFloat = op(FFloat)(x)(_ / _)
    def /(x: FDouble)(implicit ec: ExecutionContext): FDouble = op(FDouble)(x)(_ / _)

    def %(x: FByte)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ % _)
    def %(x: FShort)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ % _)
    def %(x: FChar)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ % _)
    def %(x: FInt)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ % _)
    def %(x: FLong)(implicit ec: ExecutionContext): FLong = op(FLong)(x)(_ % _)
    def %(x: FFloat)(implicit ec: ExecutionContext): FFloat = op(FFloat)(x)(_ % _)
    def %(x: FDouble)(implicit ec: ExecutionContext): FDouble = op(FDouble)(x)(_ % _)
}

object FLong extends FAnyCompanion[Long, FLong] {
    override def apply(in: Future[Long]): FLong = new FLong(in)
}
