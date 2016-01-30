package test

import com.bryghts.ftypes._
import org.specs2.mutable.Specification
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

/**
 * Created by Marc Esquerrà on 01/03/15.
 */
class SomeTest extends Specification with ValExtensions {

    "This is a basic test to chack basic aspects".txt

    "Using async" >> {
        "for basic cases" in {
            val x: async.Int = 3
            val y = x + 4
            val b: scala.Byte = 7
            val c: async.Byte = b

            Await.result(y.future, Duration.Inf) must_=== 7
        }
        "for comparisons" in {
            val x: async.Int = 3
            val y = x + 4
            val r = y === 7

            Await.result(r.future, Duration.Inf) must beTrue
            val r2 = y === async.Int(6)

            println(
                s"""
                   |
                   |
                   |
                   |
                   |-------------
                   |${4 == 4.0}
                   |-------------
                   |
                 """.stripMargin)
            Await.result(r2.future, Duration.Inf) must beFalse

        }
    }

}
