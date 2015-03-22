//package bryghts.test
//
//import java.io.{File, FileOutputStream, PrintWriter}
//
//import scala.collection.mutable.ListBuffer
//
//
//object SmokeTestGenerator extends App {
//
//    val types =
//        Byte        ::
//        Char        ::
//        Short       ::
//        Int         ::
//        Long        ::
//        Float       ::
//        Double      ::
//        BigInt      ::
//        BigDecimal  ::
//        Nil
//
//    val values = List(0, 1, -1, -99, 99)
//
//    val typeNames =
//            types.map(
//                _.getClass
//                 .getSimpleName
//                 .reverse
//                 .dropWhile(_ == '$')
//                 .reverse)
//
//    val ops =
//        '+'     ::
//        '-'     ::
//        '/'     ::
//        '*'     ::
//        Nil
//
//    def describe(a: String, b: String, iva: Int, ivb: Int, r: Char => String, out: ListBuffer[String]) = {
//        val va = prepareValue(a, iva)
//        val vb = prepareValue(b, ivb)
//        val test = ops
//            .map{op => s"""    s2" Try(AwaitResult(F$a($va) $op F$b($vb))) === Try($r) """" }
//        out += (s"""    s2"F$a($va) Vs F$b($vb) === $r $${ Try(AwaitResult(F$a($va) $op F$b($vb))) === Try($r)} }"""")
//        out += (s"""    s2" $a($va) Vs F$b($vb) === $r $${ Try(AwaitResult(    $va  $op F$b($vb))) === Try($r)} }"""")
//        out += (s"""    s2"F$a($va) Vs  $b($vb) === $r $${ Try(AwaitResult(F$a($va) $op     $vb )) === Try($r)} }"""")
//    }
//
//    def prepareValue(t: String, v: Int) = t match {
//        case "BigInt"      => s"BigInt($v)"
//        case "BigDecimal"  => s"BigDecimal($v)"
//        case _             => s"$v.to$t"
//    }
//
//    def prepareValueForBig(t: String, v: Int, otherIsFractional: Boolean) = t match {
//        case "BigInt"      => if(otherIsFractional) s"BigDecimal($t($v))" else s"$t($v)"
//        case "BigDecimal"  => s"$t($v)"
//        case "Float"       => s"BigDecimal($v)"
//        case "Double"      => s"BigDecimal($v)"
//        case _             => if(otherIsFractional) s"BigDecimal($v)" else s"BigInt($v)"
//    }
//
//    def otherIsFractional(other: String) = List(
//        "BigDecimal",
//        "Float",
//        "Double"
//    ).contains(other)
//
//    def describe(a: String, b: String, iva: Int, ivb: Int, op: Char, out: ListBuffer[String]): Unit = {
//        val va = prepareValue(a, iva)
//        val vb = prepareValue(b, ivb)
//        val bva = prepareValueForBig(a, iva, otherIsFractional(b))
//        val bvb = prepareValueForBig(b, ivb, otherIsFractional(a))
//        (a, b) match {
//            case (a,            b)                if (a.startsWith("Big") || b.startsWith("Big"))
//                                               => describe(a, b, iva, ivb, op, s"$bva $op $bvb", out)
//            case (a,            b)             => describe(a, b, iva, ivb, op, s"$va $op $vb", out)
//        }
//    }
//
//    def describe(a: String, b: String, out: ListBuffer[String]): Unit =
//        for(op <- ops)
//            for(iva <- values)
//                for(ivb <- values)
//                    describe(a, b, iva, ivb, op, out)
//
//    val out = ListBuffer.empty[String]
//    for(i <- 0 until typeNames.length)
//    {
//        val a = typeNames(i)
//        describe(a, a, out)
//        for(j <- (i + 1) until typeNames.length)
//        {
//            val b = typeNames(j)
//
//            describe(a, b, out)
//            describe(b, a, out)
//        }
//    }
//
//    val r = out.toList
//    new File(s"src/test/scala/bryghts/test/smoke")
//            .list()
//            .map(new File(_))
//            .filterNot(_.isDirectory)
//            .foreach(_.delete())
//
//    r.grouped(100).zipWithIndex.foreach{
//        case (lines, index) =>
//            generateTest("OpsSmokeTest" + index, lines)
//    }
//
//    def generateTest(testName: String, content: List[String]) = {
//        val f = new File(s"src/test/scala/bryghts/test/smoke/$testName.scala")
//        f.getParentFile.mkdirs()
//        val out = new PrintWriter(new FileOutputStream(f))
//        val header =
//            s"""
//              |package bryghts.test.smoke
//              |
//              |import java.io.{FileOutputStream, PrintWriter}
//              |
//              |import com.bryghts.ftypes._
//              |import com.bryghts.ftypes.helpers.AwaitResult
//              |import org.specs2.ScalaCheck
//              |import org.specs2.mutable.Specification
//              |
//              |import scala.concurrent.duration.Duration
//              |import scala.util.{Failure, Success, Try}
//              |
//              |/**
//              | * Created by Marc Esquerrà on 01/03/15.
//              | */
//              |class $testName extends Specification with ScalaCheck {
//              |
//              |    implicit val tiemout = Duration.Inf
//              |
//            """.stripMargin
//
//        out.println(header)
//
//        content.foreach{out.println(_)}
//
//        out.println("}")
//        out.close()
//    }
//
//
//}
//
//
