import com.bryghts.ftypes._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Awaitable, Future}
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

    def aprintln[T](in: Awaitable[T])(implicit timeout: Duration):Unit = {
        println( AwaitResult(in) )
    }

}

