package com.bryghts.ftypes.components

import com.bryghts.ftypes.FNumber
import com.bryghts.numerics.{IntegralPolyNumeric, FractionalPolyNumeric, PolyNumeric}

import scala.language.experimental.macros
import scala.language.implicitConversions
import scala.reflect.macros.whitebox.Context


class FNumericProviderMacro(val c: Context, integralMode: Boolean) {

    import c.universe._

    implicit class TypeHelpers(t: Type) {
        def typeArgumentsOf[T : TypeTag]:List[Type] = {
            val T = typeOf[T]//.typeSymbol
            val S = T.typeSymbol

            if(t =:= T){
                dbg(t.typeArgs)
                t.typeArgs
            }
            else
                t.baseClasses
                    .filter{_.isClass}
                    .filter{_ == S}
                    .flatMap{bc =>
                        bc.asClass.typeParams.map{_.asType.toType.asSeenFrom(t, S)}
                    }
        }

        def typeArgumentAt[T : TypeTag](i: Int):Type = {
            val args = typeArgumentsOf[T]
            if(i < args.length && i >= 0)
                args(i)
            else{
                val tt: TypeTag[T] = implicitly
                err(s"Could't retrieve the type argument for $tt at $i")
            }
        }
    }


    implicit class TreeHelpers(t: Tree) {
        def tt = c.typecheck(t, mode = c.TYPEmode)
        def tpe = tt.tpe
        def typeArgumentsOf[T : TypeTag]:List[Type] =
            tpe.typeArgumentsOf[T]

        def typeArgumentAt[T : TypeTag](i: Int):Type =
            tpe.typeArgumentAt[T](i)

        def implicitEvidence =
            c.inferImplicitValue(tpe)

        def isA[T : TypeTag]: Boolean =
            tpe.typeConstructor.typeSymbol == typeOf[T].typeConstructor.typeSymbol || tpe <:< typeOf[T]

        def expresionResultsIn[T : TypeTag]: Boolean =
            c.typecheck(t).tpe.typeConstructor.typeSymbol == typeOf[T].typeConstructor.typeSymbol || c.typecheck(t).tpe <:< typeOf[T]
    }


    private def err(str: String): Nothing =
    {
        dbg("ERROR: " + str)
        c.error(c.enclosingPosition, str)
        ???
    }

    private def warn(str: String): Nothing =
    {
        c.warning(c.enclosingPosition, str)
        ???
    }

    private def dbg(in: Any) =
        c.info(c.enclosingPosition, "\n\n" + in.toString + "\n", true)

    def impl[TA: c.WeakTypeTag, TB: c.WeakTypeTag]: c.Tree = {

        import c.universe._


        val A = weakTypeOf[TA]
        val B = weakTypeOf[TB]

        if(!(A <:< weakTypeOf[FNumber[_, _]]))
            err("It's not Number")

        val mixed = !(B <:< weakTypeOf[FNumber[_, _]])

        val a = A.typeArgumentAt[FNumber[_, _]](0)
        val b = if(mixed) B else B.typeArgumentAt[FNumber[_, _]](0)
        val polyNumeric =
            tq"_root_.com.bryghts.numerics.PolyNumericFor[$a, $b]"
                .implicitEvidence

        if(integralMode)
        {
            if(!polyNumeric.isA[IntegralPolyNumeric[_, _, _]])
                warn("There doesn't exist an IntegralPolyNumeric in Scope")
        }

        val r =
            polyNumeric
                .typeArgumentAt[PolyNumeric[_, _, _]](2)

        val companion =
            tq"_root_.com.bryghts.ftypes.components.FBuilderFrom[$r]"
                .implicitEvidence

        val R =
            companion
                .typeArgumentAt[FAnyCompanion[_, _]](1)

        val RT =
        if(mixed)
            if(!integralMode && polyNumeric.expresionResultsIn[FractionalPolyNumeric[_,_, _]])
                tq"""_root_.com.bryghts.ftypes.components.MixedFNumericForBaseFractionalNumeric[$a, $A, $B, $r]"""
            else
                tq"""_root_.com.bryghts.ftypes.components.MixedFNumericForBaseIntegralNumeric[$a, $A, $B, $r]"""
        else
            if(!integralMode && polyNumeric.expresionResultsIn[FractionalPolyNumeric[_,_, _]])
                tq"""_root_.com.bryghts.ftypes.components.FNumericForBaseFractionalNumeric[$a, $A, $b, $B, $r]"""
            else
                tq"""_root_.com.bryghts.ftypes.components.FNumericForBaseIntegralNumeric[$a, $A, $b, $B, $r]"""

        q"""
            new $RT($polyNumeric)
            {
                type FR = $R
                override protected val builder = $companion
            }
         """
    }


}

class FNumericProviderMacroRegularImpl(c: Context) extends FNumericProviderMacro(c, false)
class FNumericProviderMacroRegularIntegral(c: Context) extends FNumericProviderMacro(c, false)

