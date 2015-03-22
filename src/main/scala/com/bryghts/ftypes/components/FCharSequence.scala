package com.bryghts.ftypes.components

import com.bryghts.ftypes.{FInt, FChar}

import scala.concurrent.{Future, ExecutionContext}


trait FCharSequence {
    def future: Future[CharSequence]
    def charAt(index: FInt)(implicit executionContext: ExecutionContext): FChar =
        FChar(for(v <- future; p <- index.future) yield v.charAt(p))

    def length(implicit executionContext: ExecutionContext): FInt =
        FInt(future.map(_.length))

    def subSequence(start: FInt, end: FInt)(implicit executionContext: ExecutionContext): FCharSequence =
        FCharSequence(for(v <- future; p1 <- start.future; p2 <- end.future) yield v.subSequence(p1, p2))
}

object FCharSequence {
    def apply(f: Future[CharSequence]):FCharSequence = new FCharSequence {
        val future = f
    }
}