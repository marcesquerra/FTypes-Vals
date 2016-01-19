package com.bryghts


import scala.concurrent.ExecutionContext
import scala.language.implicitConversions


/**
* Created by Marc Esquerrà on 29/01/2015.
*/
package object ftypes {

    def ftrue(implicit executionContext: ExecutionContext)  = FBoolean(true)
    def ffalse(implicit executionContext: ExecutionContext) = FBoolean(false)



    implicit def implicitByteToFByte             (v: Byte)(implicit executionContext: ExecutionContext):       FByte       = FByte(v)
    implicit def implicitCharToFChar             (v: Char)(implicit executionContext: ExecutionContext):       FChar       = FChar(v)
    implicit def implicitShortToFShort           (v: Short)(implicit executionContext: ExecutionContext):      FShort      = FShort(v)
    implicit def implicitIntToFInt               (v: Int)(implicit executionContext: ExecutionContext):        FInt        = FInt(v)
    implicit def implicitLongToFLong             (v: Long)(implicit executionContext: ExecutionContext):       FLong       = FLong(v)
    implicit def implicitFloatToFFloat           (v: Float)(implicit executionContext: ExecutionContext):      FFloat      = FFloat(v)
    implicit def implicitDoubleToFDouble         (v: Double)(implicit executionContext: ExecutionContext):     FDouble     = FDouble(v)

    implicit def implicitBooleanToFBoolean       (v: Boolean)(implicit executionContext: ExecutionContext):    FBoolean    = FBoolean(v)


}

