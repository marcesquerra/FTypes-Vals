package com.bryghts.ftypes

import scala.concurrent.{ExecutionContext, Future}
import scala.language.higherKinds

/**
 * Sample Comment
 */
package object components {


    def FDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD]]
            (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD])
            (c: D => K)
            (implicit num: scala.Fractional[K]): (FNumeric[FK, FD, FK], FNumeric[FD, FK, FK]) =
                    fdefs(ck, cd, ck)(identity, c, num)

    def IDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD]]
            (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD])
            (c: D => K)
            (implicit num: scala.Integral[K]): (FIntegralNumeric[FK, FD, FK], FIntegralNumeric[FD, FK, FK]) =
                    idefs(ck, cd, ck)(identity, c, num)

    def FDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
            (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD], cr: FNumberCompanion[R, FR])
            (fromK: K => R, fromD: D => R)
            (implicit num: scala.Fractional[R]): (FNumeric[FK, FD, FR], FNumeric[FD, FK, FR]) =
                    fdefs(ck, cd, cr)(fromK, fromD, num)

    def IDefinitions[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
            (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD], cr: FNumberCompanion[R, FR])
            (fromK: K => R, fromD: D => R)
            (implicit num: scala.Integral[R]): (FIntegralNumeric[FK, FD, FR], FIntegralNumeric[FD, FK, FR]) =
                    idefs(ck, cd, cr)(fromK, fromD, num)

    def FDefinitions[T, FT <: FNumber[T, FT]]
        (c: FNumberCompanion[T, FT])(implicit num: scala.Fractional[T]): FNumeric[FT, FT, FT] = {

        def f(in:T):T = in

        val BaseNum   = Numeric [T, T, T](f _, f _, num)
        val FNum      = FNumeric[T, FT, T, FT, T, FT](c, BaseNum)

        FNum
    }

    def IDefinitions[T, FT <: FNumber[T, FT]]
        (c: FNumberCompanion[T, FT])(implicit num: scala.Integral[T]): FIntegralNumeric[FT, FT, FT] = {

        def f(in:T):T = in

        val BaseNum   = Numeric [T, T, T](f _, f _, num)
        val FNum      = FNumeric[T, FT, T, FT, T, FT](c, BaseNum)

        FNum
    }

    private def fdefs[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
        (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD], cr: FNumberCompanion[R, FR])(fromK: K => R, fromD: D => R, num: scala.Fractional[R]): (FNumeric[FK, FD, FR], FNumeric[FD, FK, FR]) = {

        val BaseNumKL = Numeric [K, D, R](fromK, fromD, num)
        val BaseNumKR = Numeric [D, K, R](fromD, fromK, num)
        val FNumKL    = FNumeric[K, FK, D, FD, R, FR](cr, BaseNumKL)
        val FNumKR    = FNumeric[D, FD, K, FK, R, FR](cr, BaseNumKR)

        (FNumKL, FNumKR)
    }

    private def idefs[K, FK <: FNumber[K, FK], D, FD <: FNumber[D, FD], R, FR <: FNumber[R, FR]]
        (ck: FNumberCompanion[K, FK], cd: FNumberCompanion[D, FD], cr: FNumberCompanion[R, FR])(fromK: K => R, fromD: D => R, num: scala.Integral[R]): (FIntegralNumeric[FK, FD, FR], FIntegralNumeric[FD, FK, FR]) = {

        val BaseNumKL = Numeric [K, D, R](fromK, fromD, num)
        val BaseNumKR = Numeric [D, K, R](fromD, fromK, num)
        val FNumKL    = FNumeric[K, FK, D, FD, R, FR](cr, BaseNumKL)
        val FNumKR    = FNumeric[D, FD, K, FK, R, FR](cr, BaseNumKR)

        (FNumKL, FNumKR)
    }
}




