package bryghts.test

import com.bryghts.ftypes._
import helpers._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
//import scala.util.Try

object Main extends App{

    implicit val timeout = Duration.Inf

//    val a = -1
//    val b = BigInt(-5911)
//
//    println(Try{a + b})
//    println(Try{AwaitResult(FInt(a) + FBigInt(b))})
//    println(AwaitResult(FInt(a) + FBigInt(b)) == a+b)

//    val a = BigInt(1)
//    val b = BigDecimal(0)
//    val c = a + b

    val a = FString("ABC")
    val b = FInt(3)
    val c = a + b

    fprintln(c)

}

