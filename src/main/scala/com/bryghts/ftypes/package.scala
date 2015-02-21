package com.bryghts

import sun.reflect.generics.reflectiveObjects.NotImplementedException

import scala.concurrent.{ExecutionContext, Future}

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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    implicit val (mimplicitCharByte,         mimplicitByteChar)          = MIDefinitions(FChar,       FByte)(_.toChar)
    implicit val (mimplicitShortByte,        mimplicitByteShort)         = MIDefinitions(FShort,      FByte)(_.toShort)
    implicit val (mimplicitIntByte,          mimplicitByteInt)           = MIDefinitions(FInt,        FByte)(_.toInt)
    implicit val (mimplicitLongByte,         mimplicitByteLong)          = MIDefinitions(FLong,       FByte)(_.toLong)
    implicit val (mimplicitFloatByte,        mimplicitByteFloat)         = MFDefinitions(FFloat,      FByte)(_.toFloat)
    implicit val (mimplicitDoubleByte,       mimplicitByteDouble)        = MFDefinitions(FDouble,     FByte)(_.toDouble)
    implicit val (mimplicitBigIntByte,       mimplicitByteBigInt)        = MIDefinitions(FBigInt,     FByte)(BigInt(_))
    implicit val (mimplicitBigDecimalByte,   mimplicitByteBigDecimal)    = MFDefinitions(FBigDecimal, FByte)(BigDecimal(_))
    implicit val (mimplicitShortChar,        mimplicitCharShort)         = MIDefinitions(FShort,      FChar)(_.toShort)
    implicit val (mimplicitIntChar,          mimplicitCharInt)           = MIDefinitions(FInt,        FChar)(_.toInt)
    implicit val (mimplicitLongChar,         mimplicitCharLong)          = MIDefinitions(FLong,       FChar)(_.toLong)
    implicit val (mimplicitFloatChar,        mimplicitCharFloat)         = MFDefinitions(FFloat,      FChar)(_.toFloat)
    implicit val (mimplicitDoubleChar,       mimplicitCharDouble)        = MFDefinitions(FDouble,     FChar)(_.toDouble)
    implicit val (mimplicitBigIntChar,       mimplicitCharBigInt)        = MIDefinitions(FBigInt,     FChar)(BigInt(_))
    implicit val (mimplicitBigDecimalChar,   mimplicitCharBigDecimal)    = MFDefinitions(FBigDecimal, FChar)(BigDecimal(_))
    implicit val (mimplicitIntShort,         mimplicitShortInt)          = MIDefinitions(FInt,        FShort)(_.toInt)
    implicit val (mimplicitLongShort,        mimplicitShortLong)         = MIDefinitions(FLong,       FShort)(_.toLong)
    implicit val (mimplicitFloatShort,       mimplicitShortFloat)        = MFDefinitions(FFloat,      FShort)(_.toFloat)
    implicit val (mimplicitDoubleShort,      mimplicitShortDouble)       = MFDefinitions(FDouble,     FShort)(_.toDouble)
    implicit val (mimplicitBigIntShort,      mimplicitShortBigInt)       = MIDefinitions(FBigInt,     FShort)(BigInt(_))
    implicit val (mimplicitBigDecimalShort,  mimplicitShortBigDecimal)   = MFDefinitions(FBigDecimal, FShort)(BigDecimal(_))
    implicit val (mimplicitLongInt,          mimplicitIntLong)           = MIDefinitions(FLong,       FInt)(_.toLong)
    implicit val (mimplicitFloatInt,         mimplicitIntFloat)          = MFDefinitions(FFloat,      FInt)(_.toFloat)
    implicit val (mimplicitDoubleInt,        mimplicitIntDouble)         = MFDefinitions(FDouble,     FInt)(_.toDouble)
    implicit val (mimplicitBigIntInt,        mimplicitIntBigInt)         = MIDefinitions(FBigInt,     FInt)(BigInt(_))
    implicit val (mimplicitBigDecimalInt,    mimplicitIntBigDecimal)     = MFDefinitions(FBigDecimal, FInt)(BigDecimal(_))
    implicit val (mimplicitFloatLong,        mimplicitLongFloat)         = MFDefinitions(FFloat,      FLong)(_.toFloat)
    implicit val (mimplicitDoubleLong,       mimplicitLongDouble)        = MFDefinitions(FDouble,     FLong)(_.toDouble)
    implicit val (mimplicitBigIntLong,       mimplicitLongBigInt)        = MIDefinitions(FBigInt,     FLong)(BigInt(_))
    implicit val (mimplicitBigDecimalLong,   mimplicitLongBigDecimal)    = MFDefinitions(FBigDecimal, FLong)(BigDecimal(_))
    implicit val (mimplicitDoubleFloat,      mimplicitFloatDouble)       = MFDefinitions(FDouble,     FFloat)(_.toDouble)
    implicit val (mimplicitBigIntFloat,      mimplicitFloatBigInt)       = MFDefinitions(FBigInt,     FFloat, FBigDecimal)(BigDecimal(_), f => BigDecimal(f.toDouble))
    implicit val (mimplicitBigDecimalFloat,  mimplicitFloatBigDecimal)   = MFDefinitions(FBigDecimal, FFloat)(f => BigDecimal(f.toDouble))
    implicit val (mimplicitBigIntDouble,     mimplicitDoubleBigInt)      = MFDefinitions(FBigInt,     FDouble, FBigDecimal)(BigDecimal(_), BigDecimal(_))
    implicit val (mimplicitBigDecimalDouble, mimplicitDoubleBigDecimal)  = MFDefinitions(FBigDecimal, FDouble)(BigDecimal(_))
    implicit val (mimplicitBigDecimalBigInt, mimplicitBigIntBigDecimal)  = MFDefinitions(FBigDecimal, FBigInt)(BigDecimal(_))



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    implicit val implicitByte = IDefinitions(FByte)
    implicit val mimplicitByte = MIDefinitions(FByte)
    implicit object FByte extends FNumberCompanion[Byte, FByte]
    implicit def FByteScalaNumeric(implicit ec: ExecutionContext): ScalaNumericForFNumbers[Byte, FByte] = new ScalaNumericForFNumbers[Byte, FByte](implicitByte)
    case class FByte(future: Future[Byte]) extends FINumber[Byte, FByte](FByte)

    implicit val implicitChar = IDefinitions(FChar)
    implicit val mimplicitChar = MIDefinitions(FChar)
    implicit object FChar extends FNumberCompanion[Char, FChar]
    implicit def FCharScalaNumeric(implicit ec: ExecutionContext): ScalaNumericForFNumbers[Char, FChar] = new ScalaNumericForFNumbers[Char, FChar](implicitChar)
    case class FChar(future: Future[Char]) extends FINumber[Char, FChar](FChar)

    implicit val implicitShort = IDefinitions(FShort)
    implicit val mimplicitShort = MIDefinitions(FShort)
    implicit object FShort extends FNumberCompanion[Short, FShort]
    implicit def FShortScalaNumeric(implicit ec: ExecutionContext): ScalaNumericForFNumbers[Short, FShort] = new ScalaNumericForFNumbers[Short, FShort](implicitShort)
    case class FShort(future: Future[Short]) extends FINumber[Short, FShort](FShort)

    implicit val implicitInt = IDefinitions(FInt)
    implicit val mimplicitInt = MIDefinitions(FInt)
    implicit object FInt extends FNumberCompanion[Int, FInt]
    implicit def FIntScalaNumeric(implicit ec: ExecutionContext): ScalaNumericForFNumbers[Int, FInt] = new ScalaNumericForFNumbers[Int, FInt](implicitInt)
    case class FInt(future: Future[Int]) extends FINumber[Int, FInt](FInt)

    implicit val implicitLong = IDefinitions(FLong)
    implicit val mimplicitLong = MIDefinitions(FLong)
    implicit object FLong extends FNumberCompanion[Long, FLong]
    implicit def FLongScalaNumeric(implicit ec: ExecutionContext): ScalaNumericForFNumbers[Long, FLong] = new ScalaNumericForFNumbers[Long, FLong](implicitLong)
    case class FLong(future: Future[Long]) extends FINumber[Long, FLong](FLong)

    implicit val implicitFloat = FDefinitions(FFloat)
    implicit val mimplicitFloat = MFDefinitions(FFloat)
    implicit object FFloat extends FNumberCompanion[Float, FFloat]
    implicit def FFloatScalaNumeric(implicit ec: ExecutionContext): ScalaNumericForFNumbers[Float, FFloat] = new ScalaNumericForFNumbers[Float, FFloat](implicitFloat)
    case class FFloat(future: Future[Float]) extends FFNumber[Float, FFloat](FFloat)

    implicit val implicitDouble = FDefinitions(FDouble)
    implicit val mimplicitDouble = MFDefinitions(FDouble)
    implicit object FDouble extends FNumberCompanion[Double, FDouble]
    implicit def FDoubleScalaNumeric(implicit ec: ExecutionContext): ScalaNumericForFNumbers[Double, FDouble] = new ScalaNumericForFNumbers[Double, FDouble](implicitDouble)
    case class FDouble(future: Future[Double]) extends FFNumber[Double, FDouble](FDouble)

    implicit val implicitBigInt = IDefinitions(FBigInt)
    implicit val mimplicitBigInt = MIDefinitions(FBigInt)
    implicit object FBigInt extends FNumberCompanion[BigInt, FBigInt]
    implicit def FBigIntScalaNumeric(implicit ec: ExecutionContext): ScalaNumericForFNumbers[BigInt, FBigInt] = new ScalaNumericForFNumbers[BigInt, FBigInt](implicitBigInt)
    case class FBigInt(future: Future[BigInt]) extends FINumber[BigInt, FBigInt](FBigInt)

    implicit val implicitBigDecimal = FDefinitions(FBigDecimal)
    implicit val mimplicitBigDecimal = MFDefinitions(FBigDecimal)
    implicit object FBigDecimal extends FNumberCompanion[BigDecimal, FBigDecimal]
    implicit def FBigDecimalScalaNumeric(implicit ec: ExecutionContext): ScalaNumericForFNumbers[BigDecimal, FBigDecimal] = new ScalaNumericForFNumbers[BigDecimal, FBigDecimal](implicitBigDecimal)
    case class FBigDecimal(future: Future[BigDecimal]) extends FFNumber[BigDecimal, FBigDecimal](FBigDecimal)

    class ScalaNumericForFNumbers[T, FT <: FNumber[T, FT]](num: FNumeric[FT, FT, FT])(implicit ec: ExecutionContext, snum: scala.Numeric[T]) extends scala.Numeric[FT] {

        override def zero: FT = num.zero

        override def one: FT = num.one

        override def abs(x: FT): FT = x.abs

        override def plus(x: FT, y: FT): FT = num.plus(x, y)

        override def times(x: FT, y: FT): FT = num.times(x, y)

        override def minus(x: FT, y: FT): FT = num.minus(x, y)

        private def notImplemented = throw new NotImplementedException()

        override def toDouble(x: FT): Double = notImplemented

        override def toFloat(x: FT): Float = notImplemented

        override def toInt(x: FT): Int = notImplemented

        override def negate(x: FT): FT = notImplemented

        override def fromInt(x: Int): FT = notImplemented

        override def toLong(x: FT): Long = notImplemented

        override def compare(x: FT, y: FT): Int = notImplemented


    }
}



