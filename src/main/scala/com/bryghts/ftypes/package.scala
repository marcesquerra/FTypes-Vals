package com.bryghts


import com.bryghts.ftypes.components._

import scala.concurrent.Future
import scala.language.experimental.macros
import scala.language.implicitConversions


/**
* Created by Marc Esquerrà on 29/01/2015.
*/
package object ftypes {

    val ftrue = FBoolean.ftrue
    val ffalse = FBoolean.ffalse

    case class FByte(future: Future[Byte]) extends FINumber[Byte, FByte](FByte)
    case class FChar(future: Future[Char]) extends FINumber[Char, FChar](FChar)
    case class FShort(future: Future[Short]) extends FINumber[Short, FShort](FShort)
    case class FInt(future: Future[Int]) extends FINumber[Int, FInt](FInt)
    case class FLong(future: Future[Long]) extends FINumber[Long, FLong](FLong)
    case class FFloat(future: Future[Float]) extends FFNumber[Float, FFloat](FFloat)
    case class FDouble(future: Future[Double]) extends FFNumber[Double, FDouble](FDouble)
    case class FBigInt(future: Future[BigInt]) extends FINumber[BigInt, FBigInt](FBigInt)
    case class FBigDecimal(future: Future[BigDecimal]) extends FFNumber[BigDecimal, FBigDecimal](FBigDecimal)

    implicit object FByte extends FNumberCompanion[Byte, FByte]
    implicit object FChar extends FNumberCompanion[Char, FChar]
    implicit object FShort extends FNumberCompanion[Short, FShort]
    implicit object FInt extends FNumberCompanion[Int, FInt]
    implicit object FLong extends FNumberCompanion[Long, FLong]
    implicit object FFloat extends FNumberCompanion[Float, FFloat]
    implicit object FDouble extends FNumberCompanion[Double, FDouble]
    implicit object FBigInt extends FNumberCompanion[BigInt, FBigInt]
    implicit object FBigDecimal extends FNumberCompanion[BigDecimal, FBigDecimal]


    implicit def implicitByteToFByte             (v: Byte):       FByte       = FByte(v)
    implicit def implicitCharToFChar             (v: Char):       FChar       = FChar(v)
    implicit def implicitShortToFShort           (v: Short):      FShort      = FShort(v)
    implicit def implicitIntToFInt               (v: Int):        FInt        = FInt(v)
    implicit def implicitLongToFLong             (v: Long):       FLong       = FLong(v)
    implicit def implicitFloatToFFloat           (v: Float):      FFloat      = FFloat(v)
    implicit def implicitDoubleToFDouble         (v: Double):     FDouble     = FDouble(v)
    implicit def implicitBigIntToFBigInt         (v: BigInt):     FBigInt     = FBigInt(v)
    implicit def implicitBigDecimalToFBigDecimal (v: BigDecimal): FBigDecimal = FBigDecimal(v)

    implicit def implicitBooleanToFBoolean       (v: Boolean):    FBoolean    = FBoolean(v)

    implicit def implicitStringToFString         (v: String):     FString     = FString(v)


//    implicit def typeToFTypeImplicitConversion[T, FT <: FAny[T, FT]](v: T)(implicit c: FAnyCompanion[T, FT]): FT =
//        c(v)

    implicit def something[A, B]:FNumeric[A, B] = macro FNumericProviderMacroRegularImpl.impl[A, B]
    implicit def somethingElse[A, B]:FIntegralNumeric[A, B] = macro FNumericProviderMacroRegularIntegral.impl[A, B]
}


