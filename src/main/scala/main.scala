import com.bryghts.ftypes._
import com.bryghts.ftypes.helpers._
import com.bryghts.ftypes.statements._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Awaitable, Future, blocking}
import scala.concurrent.duration.Duration

object Main extends App{

    implicit val timeout = Duration.Inf

    val x = FInt(1)
    val z = FInt(5)
    val w = FInt(2)
    val y = FDouble(2.1)
    val zzz = Future(3) + 8

    val a = x + y
    val b = y + x

    fprintln(z % w)
    fprintln(a)
    fprintln(b)
    fprintln(a + a)
    fprintln("----")
    fprintln(a max x)
    fprintln(a + 2)
    fprintln(2 / a)
    fprintln(y == FBigDecimal(2.13))

    val tmp:Fractional[Double] = implicitly

    tmp.div(3, 3)

    AwaitResult {
        var c = 0

        While(c < 10) {
            fprintln(c.toString)
            c += 1
        }

        If(c < 10) {fprintln("yeah")} Else {fprintln("nope")}

    }

    AwaitResult {
        var d = 0

        Do {

            d += 1
            fprintln(d.toString)
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
                fprintln("one")
                7
            case other =>
                fprintln("other")
                9
        }
        fprintln(tmp)
        tmp
    }

}

