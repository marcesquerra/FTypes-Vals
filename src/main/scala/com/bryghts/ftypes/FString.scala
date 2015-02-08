package com.bryghts.ftypes

import com.bryghts.ftypes.components.{FAny, FAnyCompanion}

import scala.concurrent.Future

object FString extends FAnyCompanion[String, FString]
case class FString(future: Future[String]) extends FAny[String, FString]
{
    protected val companion = FString
}
