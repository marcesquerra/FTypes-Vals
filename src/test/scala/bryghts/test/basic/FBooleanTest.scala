package bryghts.test.basic


import com.bryghts.ftypes._
import com.bryghts.ftypes.helpers.AwaitResult
import com.bryghts.ftypes.statements.If
import org.specs2.ScalaCheck
import org.specs2.execute.Result
import org.specs2.mutable.Specification

import scala.concurrent.Future
import scala.concurrent.duration.Duration

/**
 * Created by Marc Esquerrà on 01/03/15.
 */
class FBooleanTest extends Specification with ScalaCheck {

    implicit val tiemout = Duration.Inf


        s2"""
         Binary Operators
        ${
            for(a <- Seq(true, false); b <- Seq(true, false)) yield {
                val fa = FBoolean(a)
                val fb = FBoolean(b)

                println(s"TESTING: $a && $b")
                AwaitResult(fa && fb) === (a && b)
                AwaitResult( a && fb) === (a && b)
                AwaitResult(fa &&  b) === (a && b)

                println(s"TESTING: $a || $b")
                AwaitResult(fa || fb) === (a || b)
                AwaitResult( a || fb) === (a || b)
                AwaitResult(fa ||  b) === (a || b)

                println(s"TESTING: $a & $b")
                AwaitResult(fa & fb) === (a & b)
                AwaitResult( a & fb) === (a & b)
                AwaitResult(fa &  b) === (a & b)

                println(s"TESTING: $a | $b")
                AwaitResult(fa | fb) === (a | b)
                AwaitResult( a | fb) === (a | b)
                AwaitResult(fa |  b) === (a | b)

                println(s"TESTING: $a ^ $b")
                AwaitResult(fa ^ fb) === (a ^ b)
                AwaitResult( a ^ fb) === (a ^ b)
                AwaitResult(fa ^  b) === (a ^ b)
            }
        }
         """

        s2"""
         Unary Operators
        ${
            for(a <- Seq(true, false)) yield {
                val fa = FBoolean(a)

                println(s"TESTING: !$a")
                AwaitResult(!fa) === (!a)
            }
        }
         """

        s2"""
         Statements
        ${
            val r = If(FBoolean(true)){ success } Else { failure }
            r.await

            val r2 = If(FBoolean(false)){ failure } Else { success }
            r2.await


        }
         """
}
