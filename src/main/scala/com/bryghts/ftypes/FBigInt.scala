package com.bryghts.ftypes

import com.bryghts.ftypes.components.{FBuilder, FAnyCompanion, FAny}

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FBigInt(val future: Future[BigInt]) extends FAny[BigInt, FBigInt]{

    override protected val builder: FBuilder[BigInt, FBigInt] = FBigInt

    def op[R, FR <: FAny[R, FR], B](r: FAnyCompanion[R, FR])(fb: FAny[B, _])(f: (BigInt, B) => R)(implicit ec: ExecutionContext): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: FAny[R, FR]](r: FAnyCompanion[R, FR], f: BigInt => R)(implicit ec: ExecutionContext): FR =
        r(future.map(f))

    def isWhole()(implicit ec: ExecutionContext): FBoolean = op(FBoolean, _.isWhole())

    def fbyteValue()(implicit ec: ExecutionContext): FByte = op(FByte, _.byteValue())
    def fshortValue()(implicit ec: ExecutionContext): FShort = op(FShort, _.shortValue())
    def fintValue()(implicit ec: ExecutionContext): FInt = op(FInt, _.intValue())
    def flongValue()(implicit ec: ExecutionContext): FLong = op(FLong, _.longValue())
    def ffloatValue()(implicit ec: ExecutionContext): FFloat = op(FFloat, _.floatValue())
    def fdoubleValue()(implicit ec: ExecutionContext): FDouble = op(FDouble, _.doubleValue())

    def toFChar(implicit ec: ExecutionContext): FChar = op(FChar, _.toChar)
    def toFByte(implicit ec: ExecutionContext): FByte = op(FByte, _.toByte)
    def toFShort(implicit ec: ExecutionContext): FShort = op(FShort, _.toShort)
    def toFInt(implicit ec: ExecutionContext): FInt = op(FInt, _.toInt)
    def toFLong(implicit ec: ExecutionContext): FLong = op(FLong, _.toLong)
    def toFFloat(implicit ec: ExecutionContext): FFloat = op(FFloat, _.toFloat)
    def toFDouble(implicit ec: ExecutionContext): FDouble = op(FDouble, _.toDouble)

    def isValidFByte(implicit ec: ExecutionContext): FBoolean = op(FBoolean, _.isValidByte)
    def isValidFShort(implicit ec: ExecutionContext): FBoolean = op(FBoolean, _.isValidShort)
    def isValidFInt(implicit ec: ExecutionContext): FBoolean = op(FBoolean, _.isValidInt)
    def isValidFChar(implicit ec: ExecutionContext): FBoolean = op(FBoolean, _.isValidChar)

    def isValidFLong(implicit ec: ExecutionContext): FBoolean = op(FBoolean, _.isValidLong)
    def isValidFFloat(implicit ec: ExecutionContext): FBoolean = op(FBoolean, _.isValidFloat)
    def isValidFDouble(implicit ec: ExecutionContext): FBoolean = op(FBoolean, _.isValidDouble)

    def compare (that: FBigInt)(implicit ec: ExecutionContext): FInt = op(FInt)(that)(_ compare _)

    def <= (that: FBigInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(that)(_ <= _)

    def >= (that: FBigInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(that)(_ >= _)

    def < (that: FBigInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(that)(_ < _)

    def > (that: FBigInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(that)(_ > _)

    def + (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ + _)

    def - (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ - _)

    def * (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ * _)

    def / (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ / _)

    def % (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ % _)

    def /% (that: FBigInt)(implicit ec: ExecutionContext): (FBigInt, FBigInt) = (this / that, this % that)

    def << (n: FInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(n)(_ << _)

    def >> (n: FInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(n)(_ >> _)

    def & (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ & _)

    def | (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ | _)

    def ^ (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ ^ _)

    def &~ (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ &~ _)

    def gcd (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ gcd _)

    def mod (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ mod _)

    def min (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ min _)

    def max (that: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(that)(_ max _)

    def pow (exp: FInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(exp)(_ pow _)

    def modPow (fexp: FBigInt, fm: FBigInt)(implicit ec: ExecutionContext): FBigInt = FBigInt(
        for{
            a    <- future
            exp  <- fexp.future
            m    <- fm.future
        } yield a.modPow(exp, m)
    )

    def modInverse (m: FBigInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(m)(_ modInverse _)

    def unary_- (implicit ec: ExecutionContext): FBigInt = op(FBigInt, _.unary_-)

    def abs(implicit ec: ExecutionContext): FBigInt = op(FBigInt, _.abs)

    def signum(implicit ec: ExecutionContext): FInt = op(FInt, _.signum)

    def unary_~ (implicit ec: ExecutionContext): FBigInt = op(FBigInt, _.unary_~)

    def testBit (n: FInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(n)(_ testBit _)

    def setBit (n: FInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(n)(_ setBit _)

    def clearBit (n: FInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(n)(_ clearBit _)

    def flipBit (n: FInt)(implicit ec: ExecutionContext): FBigInt = op(FBigInt)(n)(_ flipBit _)

    def lowestSetBit(implicit ec: ExecutionContext): FInt = op(FInt, _.lowestSetBit)

    def bitLength(implicit ec: ExecutionContext): FInt = op(FInt, _.bitLength)

    def bitCount(implicit ec: ExecutionContext): FInt = op(FInt, _.bitCount)

    def isProbablePrime (certainty: FInt)(implicit ec: ExecutionContext): FBoolean = op(FBoolean)(certainty)(_ isProbablePrime _)

    def charValue(implicit ec: ExecutionContext): FChar = op(FChar, _.charValue)

//    def until(end: BigInt, step: BigInt = BigInt(1)) = Range.BigInt(this, end, step)
//
//    def to(end: BigInt, step: BigInt = BigInt(1)) = Range.BigInt.inclusive(this, end, step)

    def toString (radix: FInt)(implicit ec: ExecutionContext): FString = op(FString)(radix)(_ toString _)

    def toByteArray(implicit ec: ExecutionContext): FArray[FByte] = FArray(FByte)(future.map(_.toByteArray))
}

object FBigInt extends FAnyCompanion[BigInt, FBigInt] {
    override def apply(in: Future[BigInt]): FBigInt = new FBigInt(in)
}
