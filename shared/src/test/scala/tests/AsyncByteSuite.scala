package tests

import com.bryghts.ftypes._
import utest._
import utest.ExecutionContext.RunNow


/**
 * Created by Marc Esquerrà on 23/01/2016.
 */
object SmokeTest  extends TestSuite{

    val tests = TestSuite{
        "async.Boolean" - {
            'Inequality {
                val x = async.True
                val y = async.False

                asyncAssert(x =!= y)
                compileError("x =!= 3")
                val n = async.Int(3)
                compileError("x =!= n")
            }
            'Equality {
                val x = async.True
                val y = async.True

                asyncAssert(x === y)
                compileError("x === 3")
                val n = async.Int(3)
                compileError("x === n")
            }
            "operators" - {
                for ( b1 <- List(true, false))
                {
                    for ( b2 <- List(true, false))
                    {
                        val ab1 = async.Boolean(b1)
                        val ab2 = async.Boolean(b1)

                        asyncAssert((ab1 || ab2) === (b1 || b2))
                        asyncAssert((ab1 && ab2) === (b1 && b2))
                        asyncAssert((ab1 |  ab2) === (b1 |  b2))
                        asyncAssert((ab1 &  ab2) === (b1 &  b2))
                        asyncAssert((ab1 ^  ab2) === (b1 ^  b2))
                    }
                }
            }
        }
    }

    def asyncAssert(p: async.Boolean) =
        p.future.map(r => assert(r))
}
