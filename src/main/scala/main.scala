import com.bryghts.ftypes._
import com.bryghts.ftypes.statements._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Awaitable, Future, blocking}
import scala.concurrent.duration.Duration

object Main extends App{

    implicit val timeout = Duration.Inf

    val x = FInt(1)
    val y = FDouble(2.1)

    val a = x + y
    val b = y + x

    aprintln(a)
    aprintln(b)
    aprintln(a + a)
//    aprintln(a + 2)
    aprintln(2 / a)
    aprintln(y == FBigDecimal(2.13))

    val tmp:Fractional[Double] = implicitly

    tmp.div(3, 3)

    AwaitResult {
        var c = 0

        While(c < 10) {
            println(c)
            c += 1
        }

        If(c < 10) {println("yeah")} Else {println("nope")}

    }

    def aprintln[T](in: Awaitable[T])(implicit timeout: Duration):Unit = {
        println( AwaitResult(in) )
    }

    AwaitResult {
        var d = 0

        Do {

            d += 1
            println(d)
        } While ({
            Future{
                blocking{
                    Thread.sleep(200)
                }
                d < 10
            }
        })

        val tmp = a Match {
            case 1 =>
                println("one")
                7
            case other =>
                println("other")
                9
        }
        aprintln(tmp)
        tmp
    }

}

