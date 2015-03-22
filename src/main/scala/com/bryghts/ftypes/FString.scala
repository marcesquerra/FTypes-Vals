package com.bryghts.ftypes

import java.nio.charset.Charset
import java.util.Locale

import com.bryghts.ftypes.components.{FCharSequence, FAny, FAnyCompanion}

import scala.concurrent.{ExecutionContext, Future}

case class FString(future: Future[String])          extends FAny[String, FString]
                                                       with FCharSequence
{
    protected val builder = FString


    def isEmpty(implicit ec: ExecutionContext): FBoolean = FBoolean(future.map(_.isEmpty))
    def codePointAt(index: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p <- index.future) yield v.codePointAt(p))
    def codePointBefore(index: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p <- index.future) yield v.codePointBefore(p))
    def codePointCount(beginIndex: FInt, endIndex: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p1 <- beginIndex.future; p2 <- endIndex.future) yield v.codePointCount(p1, p2))
    def offsetByCodePoints(index: FInt, codePointOffset: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p1 <- index.future; p2 <- codePointOffset.future) yield v.offsetByCodePoints(p1, p2))
    def getBytes(charsetName: FString)(implicit ec: ExecutionContext): FArray[FByte] = FArray(FByte)(for(v <- future; p <- charsetName.future) yield v.getBytes(p))
    def getBytes(implicit ec: ExecutionContext): FArray[FByte] = FArray(FByte)(future.map(_.getBytes))
    def equalsIgnoreCase(anotherString: FString)(implicit ec: ExecutionContext): FBoolean = FBoolean(for(v <- future; p <- anotherString.future) yield v.equalsIgnoreCase(p))
    def compareTo(anotherString: FString)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p <- anotherString.future) yield v.compareTo(p))
    def compareToIgnoreCase(str: FString)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p <- str.future) yield v.compareToIgnoreCase(p))
    def regionMatches(toffset: FInt, other: FString, ooffset: FInt, len: FInt)(implicit ec: ExecutionContext): FBoolean = FBoolean(for(v <- future; p1 <- toffset.future; p2 <- other.future; p3 <- ooffset.future; p4 <- len.future) yield v.regionMatches(p1, p2, p3, p4))
    def regionMatches(ignoreCase: FBoolean, toffset: FInt, other: FString, ooffset: FInt, len: FInt)(implicit ec: ExecutionContext): FBoolean = ???
    def startsWith(prefix: FString, toffset: FInt)(implicit ec: ExecutionContext): FBoolean = FBoolean(for(v <- future; p1 <- prefix.future; p2 <- toffset.future) yield v.startsWith(p1, p2))
    def startsWith(prefix: FString)(implicit ec: ExecutionContext): FBoolean = FBoolean(for(v <- future; p <- prefix.future) yield v.startsWith(p))
    def endsWith(suffix: FString)(implicit ec: ExecutionContext): FBoolean = FBoolean(for(v <- future; p <- suffix.future) yield v.endsWith(p))
    def indexOf(ch: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p <- ch.future) yield v.indexOf(p))
    def indexOf(ch: FInt, fromIndex: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p1 <- ch.future; p2 <- fromIndex.future) yield v.indexOf(p1, p2))
    def lastIndexOf(ch: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p <- ch.future) yield v.lastIndexOf(p))
    def lastIndexOf(ch: FInt, fromIndex: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p1 <- ch.future; p2 <- fromIndex.future) yield v.lastIndexOf(p1, p2))
    def indexOf(str: FString)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p <- str.future) yield v.indexOf(p))
    def indexOf(str: FString, fromIndex: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p1 <- str.future; p2 <- fromIndex.future) yield v.indexOf(p1, p2))
    def lastIndexOf(str: FString)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p <- str.future) yield v.lastIndexOf(p))
    def lastIndexOf(str: FString, fromIndex: FInt)(implicit ec: ExecutionContext): FInt = FInt(for(v <- future; p1 <- str.future; p2 <- fromIndex.future) yield v.lastIndexOf(p1, p2))
    def substring(beginIndex: FInt)(implicit ec: ExecutionContext): FString = FString(for(v <- future; p <- beginIndex.future) yield v.substring(p))
    def substring(beginIndex: FInt, endIndex: FInt)(implicit ec: ExecutionContext): FString = FString(for(v <- future; p1 <- beginIndex.future; p2 <- endIndex.future) yield v.substring(p1, p2))
    def concat(str: FString)(implicit ec: ExecutionContext): FString = FString(for(v <- future; p <- str.future) yield v.concat(p))
    def replace(oldChar: FChar, newChar: FChar)(implicit ec: ExecutionContext): FString = FString(for(v <- future; p1 <- oldChar.future; p2 <- newChar.future) yield v.replace(p1, p2))
    def matches(regex: FString)(implicit ec: ExecutionContext): FBoolean = FBoolean(for(v <- future; p <- regex.future) yield v.matches(p))
    def replaceFirst(regex: FString, replacement: FString)(implicit ec: ExecutionContext): FString = FString(for(v <- future; p1 <- regex.future; p2 <- replacement.future) yield v.replaceFirst(p1, p2))
    def replaceAll(regex: FString, replacement: FString)(implicit ec: ExecutionContext): FString = FString(for(v <- future; p1 <- regex.future; p2 <- replacement.future) yield v.replaceAll(p1, p2))
    def split(regex: FString, limit: FInt)(implicit ec: ExecutionContext): FArray[FString] = FArray(FString)(for(v <- future; p1 <- regex.future; p2 <- limit.future) yield v.split(p1, p2))
    def split(regex: FString)(implicit ec: ExecutionContext): FArray[FString] = FArray(FString)(for(v <- future; p <- regex.future) yield v.split(p))
    def toLowerCase(implicit ec: ExecutionContext): FString = FString(future.map(_.toLowerCase))
    def toUpperCase(implicit ec: ExecutionContext): FString = FString(future.map(_.toUpperCase))
    def trim(implicit ec: ExecutionContext): FString = FString(future.map(_.trim))
    def toCharArray(implicit ec: ExecutionContext): FArray[FChar] = FArray(FChar)(future.map(_.toCharArray))
    def +[T <: FAny[_, T]] (other: T)(implicit ec: ExecutionContext): FString = concat(other.toFString)




    override def toFString(implicit ec: ExecutionContext):FString = this


    def getBytes(charset: Charset)(implicit ec: ExecutionContext): FArray[FByte] = FArray(FByte)(for(v <- future) yield v.getBytes(charset))
//    def contentEquals(sb: StringBuffer)(implicit ec: ExecutionContext): Boolean = Boolean(for(v <- future; p <- sb.future) yield v.contentEquals(p))
    def contentEquals(cs: FCharSequence)(implicit ec: ExecutionContext): FBoolean = FBoolean(for(v <- future; p <- cs.future) yield v.contentEquals(p))
    def contains(s: FCharSequence)(implicit ec: ExecutionContext): FBoolean = FBoolean(for(v <- future; p <- s.future) yield v.contains(p))
    def replace(target: FCharSequence, replacement: FCharSequence)(implicit ec: ExecutionContext): FString = FString(for(v <- future; p1 <- target.future; p2 <- replacement.future) yield v.replace(p1, p2))
    def toLowerCase(locale: Locale)(implicit ec: ExecutionContext): FString = FString(for(v <- future) yield v.toLowerCase(locale))
    def toUpperCase(locale: Locale)(implicit ec: ExecutionContext): FString = FString(for(v <- future) yield v.toUpperCase(locale))

    // FCharSequence
//    override def length(implicit ec: ExecutionContext): FInt = FInt(future.map(_.length))
//    override def subSequence(beginIndex: FInt, endIndex: FInt)(implicit ec: ExecutionContext): FCharSequence = FCharSequence(for(v <- future; p1 <- beginIndex.future; p2 <- endIndex.future) yield v.subSequence(p1, p2))
//    override def charAt(index: FInt)(implicit executionContext: ExecutionContext): FChar = FChar(for(v <- future; p <- index.future) yield v.charAt(p))

}

object FString extends FAnyCompanion[String, FString]
