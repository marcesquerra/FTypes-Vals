package com.bryghts.ftypes

import com.bryghts.ftypes.components.{FAnyCompanion, FAny}

import scala.concurrent.duration.Duration
import scala.concurrent._
import scala.language.implicitConversions

object FBoolean extends FAnyCompanion[Boolean, FBoolean]
{
    val ftrue  = FBoolean(true)
    val ffalse = FBoolean(false)

    type FA = FBoolean
}

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
case class FBoolean(future: Future[Boolean]) extends FAny[Boolean, FBoolean]
{

    protected val builder = FBoolean

    def op(x: FBoolean, f: (Boolean, Boolean) => Boolean)(implicit ec: ExecutionContext):FBoolean =
            FBoolean(future.flatMap(a => x.future.map(b => f(a, b))))

    def unary_!              (implicit ec: ExecutionContext): FBoolean = future.map(! _)

    def ||      (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ || _)
    def &&      (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ && _)
    def |       (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ |  _)
    def &       (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ &  _)
    def ^       (x: FBoolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ ^  _)

    def ||      (x:  Boolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ || _)
    def &&      (x:  Boolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ && _)
    def |       (x:  Boolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ |  _)
    def &       (x:  Boolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ &  _)
    def ^       (x:  Boolean)(implicit ec: ExecutionContext): FBoolean = op(x, _ ^  _)

    override def toFString(implicit ec: ExecutionContext):FString =
        future.map{
            case true => "ftrue"
            case false => "ffalse"
        }
}

