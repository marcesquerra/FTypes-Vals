//package com.bryghts.ftypes
//
//import com.bryghts.ftypes.components.FAny
//
//import scala.concurrent.{Future, ExecutionContext}
//
//package object statements {
//
//    implicit class MatchAdder[T, F <: FAny[T]] (val in: FAny[T]) extends AnyVal {
//        def Match[S](f: T => S)(implicit ec: ExecutionContext): Future[S] =
//            in.future.map(f)(ec)
//    }
//
//}
//
//
