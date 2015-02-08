package com.bryghts

import scala.concurrent.Future

/**
 * Created by Marc Esquerrà on 29/01/2015.
 */
package object ftypes {

    import components._

    implicit val (implicitCharByte,         implicitByteChar)          = IDefinitions(FChar,       FByte)(_.toChar)
    implicit val (implicitShortByte,        implicitByteShort)         = IDefinitions(FShort,      FByte)(_.toShort)
    implicit val (implicitIntByte,          implicitByteInt)           = IDefinitions(FInt,        FByte)(_.toInt)
    implicit val (implicitLongByte,         implicitByteLong)          = IDefinitions(FLong,       FByte)(_.toLong)
    implicit val (implicitFloatByte,        implicitByteFloat)         = FDefinitions(FFloat,      FByte)(_.toFloat)
    implicit val (implicitDoubleByte,       implicitByteDouble)        = FDefinitions(FDouble,     FByte)(_.toDouble)
    implicit val (implicitBigIntByte,       implicitByteBigInt)        = IDefinitions(FBigInt,     FByte)(BigInt(_))
    implicit val (implicitBigDecimalByte,   implicitByteBigDecimal)    = FDefinitions(FBigDecimal, FByte)(BigDecimal(_))
    implicit val (implicitShortChar,        implicitCharShort)         = IDefinitions(FShort,      FChar)(_.toShort)
    implicit val (implicitIntChar,          implicitCharInt)           = IDefinitions(FInt,        FChar)(_.toInt)
    implicit val (implicitLongChar,         implicitCharLong)          = IDefinitions(FLong,       FChar)(_.toLong)
    implicit val (implicitFloatChar,        implicitCharFloat)         = FDefinitions(FFloat,      FChar)(_.toFloat)
    implicit val (implicitDoubleChar,       implicitCharDouble)        = FDefinitions(FDouble,     FChar)(_.toDouble)
    implicit val (implicitBigIntChar,       implicitCharBigInt)        = IDefinitions(FBigInt,     FChar)(BigInt(_))
    implicit val (implicitBigDecimalChar,   implicitCharBigDecimal)    = FDefinitions(FBigDecimal, FChar)(BigDecimal(_))
    implicit val (implicitIntShort,         implicitShortInt)          = IDefinitions(FInt,        FShort)(_.toInt)
    implicit val (implicitLongShort,        implicitShortLong)         = IDefinitions(FLong,       FShort)(_.toLong)
    implicit val (implicitFloatShort,       implicitShortFloat)        = FDefinitions(FFloat,      FShort)(_.toFloat)
    implicit val (implicitDoubleShort,      implicitShortDouble)       = FDefinitions(FDouble,     FShort)(_.toDouble)
    implicit val (implicitBigIntShort,      implicitShortBigInt)       = IDefinitions(FBigInt,     FShort)(BigInt(_))
    implicit val (implicitBigDecimalShort,  implicitShortBigDecimal)   = FDefinitions(FBigDecimal, FShort)(BigDecimal(_))
    implicit val (implicitLongInt,          implicitIntLong)           = IDefinitions(FLong,       FInt)(_.toLong)
    implicit val (implicitFloatInt,         implicitIntFloat)          = FDefinitions(FFloat,      FInt)(_.toFloat)
    implicit val (implicitDoubleInt,        implicitIntDouble)         = FDefinitions(FDouble,     FInt)(_.toDouble)
    implicit val (implicitBigIntInt,        implicitIntBigInt)         = IDefinitions(FBigInt,     FInt)(BigInt(_))
    implicit val (implicitBigDecimalInt,    implicitIntBigDecimal)     = FDefinitions(FBigDecimal, FInt)(BigDecimal(_))
    implicit val (implicitFloatLong,        implicitLongFloat)         = FDefinitions(FFloat,      FLong)(_.toFloat)
    implicit val (implicitDoubleLong,       implicitLongDouble)        = FDefinitions(FDouble,     FLong)(_.toDouble)
    implicit val (implicitBigIntLong,       implicitLongBigInt)        = IDefinitions(FBigInt,     FLong)(BigInt(_))
    implicit val (implicitBigDecimalLong,   implicitLongBigDecimal)    = FDefinitions(FBigDecimal, FLong)(BigDecimal(_))
    implicit val (implicitDoubleFloat,      implicitFloatDouble)       = FDefinitions(FDouble,     FFloat)(_.toDouble)
    implicit val (implicitBigIntFloat,      implicitFloatBigInt)       = FDefinitions(FBigInt,     FFloat, FBigDecimal)(BigDecimal(_), f => BigDecimal(f.toDouble))
    implicit val (implicitBigDecimalFloat,  implicitFloatBigDecimal)   = FDefinitions(FBigDecimal, FFloat)(f => BigDecimal(f.toDouble))
    implicit val (implicitBigIntDouble,     implicitDoubleBigInt)      = FDefinitions(FBigInt,     FDouble, FBigDecimal)(BigDecimal(_), BigDecimal(_))
    implicit val (implicitBigDecimalDouble, implicitDoubleBigDecimal)  = FDefinitions(FBigDecimal, FDouble)(BigDecimal(_))
    implicit val (implicitBigDecimalBigInt, implicitBigIntBigDecimal)  = FDefinitions(FBigDecimal, FBigInt)(BigDecimal(_))

    implicit object FByte extends FAnyCompanion[Byte, FByte]
    case class FByte(future: Future[Byte]) extends FINumber[Byte, FByte](FByte)

    implicit object FChar extends FAnyCompanion[Char, FChar]
    case class FChar(future: Future[Char]) extends FINumber[Char, FChar](FChar)

    implicit object FShort extends FAnyCompanion[Short, FShort]
    case class FShort(future: Future[Short]) extends FINumber[Short, FShort](FShort)

    implicit object FInt extends FAnyCompanion[Int, FInt]
    case class FInt(future: Future[Int]) extends FINumber[Int, FInt](FInt)

    implicit object FLong extends FAnyCompanion[Long, FLong]
    case class FLong(future: Future[Long]) extends FINumber[Long, FLong](FLong)

    implicit object FFloat extends FAnyCompanion[Float, FFloat]
    case class FFloat(future: Future[Float]) extends FFNumber[Float, FFloat](FFloat)

    implicit object FDouble extends FAnyCompanion[Double, FDouble]
    case class FDouble(future: Future[Double]) extends FFNumber[Double, FDouble](FDouble)

    implicit object FBigInt extends FAnyCompanion[BigInt, FBigInt]
    case class FBigInt(future: Future[BigInt]) extends FINumber[BigInt, FBigInt](FBigInt)

    implicit object FBigDecimal extends FAnyCompanion[BigDecimal, FBigDecimal]
    case class FBigDecimal(future: Future[BigDecimal]) extends FFNumber[BigDecimal, FBigDecimal](FBigDecimal)

}



