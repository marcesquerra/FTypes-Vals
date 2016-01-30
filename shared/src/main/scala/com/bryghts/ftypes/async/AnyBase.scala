package com.bryghts.ftypes
package async

import scala.annotation.implicitNotFound
import scala.concurrent._

/**
 * Created by Marc Esquerrà on 22/01/2015.
 */
trait AnyBase[A, FA <: AnyBase[A, FA]] {self =>

    Option
    implicit def executionContext:ExecutionContext

    val future: Future[A]

    def ===   [VFB, FB >: FA <: async.Any[FB]]  (x: VFB)(implicit f: VFB => FB): async.Boolean =
        async.Boolean(future.flatMap(a => x.future.map(b => a == b)))

//    def =!=   [FB >: FA]  (x: FB): async.Boolean =
//        async.Boolean(future.flatMap(a => x.future.map(b => a != b)))

//    def unsafeEquals[FB <: async.Any[_]]  (x: FB): async.Boolean =
//        async.Boolean(future.flatMap(a => x.future.map(b => a equals b)))

}

//object ViewWiseBalancedEquality {
//    implicit class Equal[L <: async.Any[L]](val left: L) extends AnyVal {
//        def ===[R](right: R)(implicit equality: Equality[L, R]): Boolean =
//            equality.areEqual(left, right)
//    }
//    @implicitNotFound("AsyncEquality requires ${L} and ${R} to be in an implicit conversion relationship, i.e. one can be viewed as the other!")
//    sealed trait Equality[L, R] {
//        def areEqual(left: L, right: R): Boolean
//    }
//    object Equality extends LowPriorityEqualityImplicits {
//        implicit def rightToLeftEquality[L, R](implicit view: R => L): Equality[L, R] =
//            new RightToLeftViewEquality(view)
//    }
//    trait LowPriorityEqualityImplicits {
//        implicit def leftToRightEquality[L, R](implicit view: L => R): Equality[L, R] =
//            new LeftToRightViewEquality(view)
//    }
//    private class LeftToRightViewEquality[L, R](view: L => R) extends Equality[L, R] {
//        override def areEqual(left: L, right: R): Boolean =
//            view(left) == right
//    }
//    private class RightToLeftViewEquality[L, R](view: R => L) extends Equality[L, R] {
//        override def areEqual(left: L, right: R): Boolean =
//            left == view(right)
//    }
//}
