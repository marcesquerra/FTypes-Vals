package bryghts.test

import java.io.{FileOutputStream, PrintWriter}

import scala.collection.mutable.ListBuffer


object TestGenerator extends App {

    val types =
        Byte        ::
        Char        ::
        Short       ::
        Int         ::
        Long        ::
        Float       ::
        Double      ::
        BigInt      ::
        BigDecimal  ::
        Nil


    val typeNames =
        types.map(
            _.getClass
                .getSimpleName
                .reverse
                .dropWhile(_ == '$')
                .reverse)

    val ops =
        '+'     ::
        '-'     ::
        '/'     ::
        '*'     ::
        Nil

    def describe(a: String, b: String, op: Char, r: String, out: ListBuffer[String]) = {
        val va = prepareValue(a, "a")
        val vb = prepareValue(b, "b")
        val ta = prepareType(a)
        val tb = prepareType(b)
        out += (s"""    s2"F$a $op F$b $${ prop { (a: $ta, b: $tb) => Try(AwaitResult(F$a($va) $op F$b($vb))) === Try($r)} }"""")
        out += (s"""    s2" $a $op F$b $${ prop { (a: $ta, b: $tb) => Try(AwaitResult(    $va  $op F$b($vb))) === Try($r)} }"""")
        out += (s"""    s2"F$a $op  $b $${ prop { (a: $ta, b: $tb) => Try(AwaitResult(F$a($va) $op     $vb )) === Try($r)} }"""")
    }

    def prepareType(t: String) = t match {
        case "BigInt"      => "Short"
        case "BigDecimal"  => "Short"
        case "Double"      => "Short"
        case "Float"       => "Short"
        case "Long"        => "Short"
        case t             => t
    }

    def prepareValue(t: String, v: String) = t match {
        case "BigInt"      => s"BigInt($v)"
        case "BigDecimal"  => s"BigDecimal($v)"
        case "Double"      => s"$v.toDouble"
        case "Float"       => s"$v.toFloat"
        case "Long"        => s"$v.toLong"
        case _             => v
    }

    def describe(a: String, b: String, op: Char, out: ListBuffer[String]): Unit = {
        val va = prepareValue(a, "a")
        val vb = prepareValue(b, "b")
        (a, b) match {
            case ("Float", "BigInt")  => describe(a, b, op, s"BigDecimal($va.toDouble) $op BigDecimal($vb)", out)
            case ("BigInt", "Float")  => describe(a, b, op, s"BigDecimal($va) $op BigDecimal($vb.toDouble)", out)
            case ("Int", "BigInt")    => describe(a, b, op, s"BigInt($va) $op $vb", out)
            case ("BigInt", "Int")    => describe(a, b, op, s"$va $op BigInt($vb)", out)
            case ("Double", "BigInt") => describe(a, b, op, s"BigDecimal($va) $op BigDecimal($vb)", out)
            case ("BigInt", "Double") => describe(a, b, op, s"BigDecimal($va) $op BigDecimal($vb)", out)
            case ("BigDecimal", "BigInt") => describe(a, b, op, s"$va $op BigDecimal($vb)", out)
            case ("BigInt", "BigDecimal") => describe(a, b, op, s"BigDecimal($va) $op $vb", out)
            case ("BigDecimal", "Int") => describe(a, b, op, s"$va $op BigDecimal($vb)", out)
            case ("Int", "BigDecimal") => describe(a, b, op, s"BigDecimal($va) $op $vb", out)
            case ("BigDecimal", "Double") => describe(a, b, op, s"$va $op BigDecimal($vb)", out)
            case ("Double", "BigDecimal") => describe(a, b, op, s"BigDecimal($va) $op $vb", out)
            case (a, b)                   => describe(a, b, op, s"$va $op $vb", out)
        }
    }

    def describe(a: String, b: String, out: ListBuffer[String]): Unit =
        for(op <- ops)
            describe(a, b, op, out)

    val out = ListBuffer.empty[String]
    for(i <- 0 until typeNames.length)
    {
        val a = typeNames(i)
        describe(a, a, out)
        for(j <- (i + 1) until typeNames.length)
        {
            val b = typeNames(j)

            describe(a, b, out)
            describe(b, a, out)
        }
    }

    val r = out.toList
    r.grouped(100).zipWithIndex.foreach{
        case (lines, index) =>
            generateTest("OpsTest" + (('A' + index).toChar), lines)
    }

    def generateTest(testName: String, content: List[String]) = {
        val out = new PrintWriter(new FileOutputStream(s"src/test/scala/bryghts/test/$testName.scala"))
        val header =
            s"""
              |package bryghts.test
              |
              |import java.io.{FileOutputStream, PrintWriter}
              |
              |import com.bryghts.ftypes._
              |import com.bryghts.ftypes.helpers.AwaitResult
              |import org.specs2.ScalaCheck
              |import org.specs2.mutable.Specification
              |
              |import scala.concurrent.duration.Duration
              |import scala.util.{Failure, Success, Try}
              |
              |/**
              | * Created by Marc Esquerrà on 01/03/15.
              | */
              |class $testName extends Specification with ScalaCheck {
              |
              |    implicit val tiemout = Duration.Inf
              |
              |    implicit class TryComparator[T](val t: Try[T]) {
              |        def ===[O](other: Try[O]) = (t, other) match {
              |            case (Success(t: Double), Success(o: Double)) =>
              |                if(t.isNaN) o.isNaN
              |                else  t == o
              |            case (Success(t), Success(o)) =>
              |                t == o
              |            case (Failure(ft),Failure(fo)) =>
              |                ft.getClass == fo.getClass // && ft.getMessage == fo.getMessage
              |            case _ =>
              |                false
              |        }
              |    }
              |
            """.stripMargin

        out.println(header)

        content.foreach{out.println(_)}

        out.println("}")
        out.close()
    }

}


