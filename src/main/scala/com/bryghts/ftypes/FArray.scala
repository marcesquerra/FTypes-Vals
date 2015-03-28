package com.bryghts.ftypes

import com.bryghts.ftypes.components.{FBuilderOf, FBuilder, FAnyCompanion, FAny}

import scala.concurrent.{ExecutionContext, Future}
import scala.reflect.ClassTag

/**
 * Created by Marc Esquerrà on 18/03/15.
 */
class FArray[FT <: FAny[_, FT]](val future: Future[Array[FT]], elementBuilder: FBuilderOf[FT]) extends FAny[Array[FT], FArray[FT]] {

    def length(implicit ec: ExecutionContext): FInt = FInt(future.map(_.length))

    def apply(i: Int)(implicit ec: ExecutionContext): FT =
        elementBuilder(future.flatMap(_.apply(i).future).asInstanceOf[Future[elementBuilder.Type]])

    override protected val builder: FBuilder[Array[FT], FArray[FT]] = new FBuilder[Array[FT], FArray[FT]] {
        override def apply(a: Array[FT]): FArray[FT] = ???

        override def apply(in: Future[Array[FT]]): FArray[FT] = ???
    }
}

object FArray {

    case class FArrayCompanionBuilder[T, FT <: FAny[T, FT]](b: FAnyCompanion[T, FT]) {

        def apply(in: Array[T])(implicit executionContext: ExecutionContext, ct: ClassTag[FT]):FArray[FT] = apply(Future.successful(in))
        def apply(in: Array[FT])(implicit executionContext: ExecutionContext, ct: ClassTag[FT]):FArray[FT] = apply(Future.successful(in))
        def apply(in: Future[Array[T]])(implicit executionContext: ExecutionContext, ct: ClassTag[FT]):FArray[FT] = {
            val next: Future[Array[FT]] = in.map(_.map(e => b(e)).toArray(ct))

            apply(next)
        }
        def apply(in: Future[Array[FT]]):FArray[FT] =
            new FArray[FT](in, b)
    }

    def apply[T, FT <: FAny[T, FT]](b: FAnyCompanion[T, FT]) = FArrayCompanionBuilder[T, FT](b)
}
