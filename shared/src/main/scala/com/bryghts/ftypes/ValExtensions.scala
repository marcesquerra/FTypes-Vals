package com.bryghts.ftypes


import com.bryghts.ftypes.async._

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions


/**
* Created by Marc Esquerrà on 29/01/2015.
*/
trait ValExtensions {

    def ftrue  (implicit executionContext: ExecutionContext) = async.Boolean(true)
    def ffalse (implicit executionContext: ExecutionContext) = async.Boolean(false)



    implicit def implicitByteToFByte             (v: scala.Byte)    (implicit executionContext: ExecutionContext): async.Byte       = async.Byte(v)
    implicit def implicitCharToFChar             (v: scala.Char)    (implicit executionContext: ExecutionContext): async.Char       = async.Char(v)
    implicit def implicitShortToFShort           (v: scala.Short)   (implicit executionContext: ExecutionContext): async.Short      = async.Short(v)
    implicit def implicitIntToFInt               (v: scala.Int)     (implicit executionContext: ExecutionContext): async.Int        = async.Int(v)
    implicit def implicitLongToFLong             (v: scala.Long)    (implicit executionContext: ExecutionContext): async.Long       = async.Long(v)
    implicit def implicitFloatToFFloat           (v: scala.Float)   (implicit executionContext: ExecutionContext): async.Float      = async.Float(v)
    implicit def implicitDoubleToFDouble         (v: scala.Double)  (implicit executionContext: ExecutionContext): async.Double     = async.Double(v)

    implicit def implicitBooleanToFBoolean       (v: scala.Boolean) (implicit executionContext: ExecutionContext): async.Boolean    = async.Boolean(v)


}

