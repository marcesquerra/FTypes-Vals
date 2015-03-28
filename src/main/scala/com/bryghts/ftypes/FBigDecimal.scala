package com.bryghts.ftypes

import com.bryghts.ftypes.components.{FBuilder, FAnyCompanion, FAny}

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 24/03/15.
 */
class FBigDecimal(val future: Future[BigDecimal]) extends FAny[BigDecimal, FBigDecimal]{

    override protected val builder: FBuilder[BigDecimal, FBigDecimal] = FBigDecimal

    def op[R, FR <: FAny[R, FR], B](r: FAnyCompanion[R, FR])(fb: FAny[B, _])(f: (BigDecimal, B) => R)(implicit ec: ExecutionContext): FR =
        r(future.flatMap(a => fb.future.map(b => f(a, b))))

    def op[R, FR <: FAny[R, FR]](r: FAnyCompanion[R, FR], f: BigDecimal => R)(implicit ec: ExecutionContext): FR =
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

}

object FBigDecimal extends FAnyCompanion[BigDecimal, FBigDecimal] {
    override def apply(in: Future[BigDecimal]): FBigDecimal = new FBigDecimal(in)
}
