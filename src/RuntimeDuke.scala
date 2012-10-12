
import language.experimental.macros
import scala.reflect.runtime.{universe=>ru}
import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox

object RuntimeDuke {

  def astPlus( x:Int, y:Int ) = {
    val tree = Apply(
      Select(
        Literal(Constant(x)),
        newTermName("$plus")
      ),
      List(
        Literal(Constant(y))
      )
    )


    
    val cm = ru.runtimeMirror(getClass.getClassLoader)

    cm.mkToolBox().eval(tree)
  }

}
