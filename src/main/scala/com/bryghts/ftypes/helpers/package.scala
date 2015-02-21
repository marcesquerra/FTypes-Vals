package com.bryghts.ftypes

import java.util.concurrent.LinkedBlockingQueue

import scala.concurrent.duration.Duration
import scala.concurrent.{Awaitable, Future}

/**
 * Created by dunlord on 21/02/15.
 */
package object helpers {

    private case class ToPrint(body: Awaitable[Any], addNewLine: Boolean, timeout: Duration)

    private val printBuffer = new LinkedBlockingQueue[ToPrint]()

    private object Printer extends Thread {
        override def run() = {
            while(true) {
                val result = try {
                    Some(printBuffer.take()) : Option[ToPrint]
                }
                catch {
                    case t: Throwable =>
                        None : Option[ToPrint]
                }

                result match {
                    case Some(ToPrint(body, false, timeout)) => print(AwaitResult(body)(timeout))
                    case Some(ToPrint(body, true, timeout))  => println(AwaitResult(body)(timeout))
                    case None =>
                }
            }
        }
    }

    Printer.start()

    def fprint[T](in: Awaitable[T])(implicit timeout: Duration): Unit = printBuffer.add(ToPrint(in, false, timeout))
    def fprintln[T](in: Awaitable[T])(implicit timeout: Duration): Unit = printBuffer.add(ToPrint(in, true, timeout))
    def fprint(in: String)(implicit timeout: Duration): Unit = fprint(Future.successful(in))
    def fprintln(in: String)(implicit timeout: Duration): Unit = fprintln(Future.successful(in))
}
