package com.bryghts


import scala.language.implicitConversions


/**
* Created by Marc Esquerrà on 29/01/2015.
*/
package object ftypes {

    val ftrue = FBoolean.ftrue
    val ffalse = FBoolean.ffalse



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


}


