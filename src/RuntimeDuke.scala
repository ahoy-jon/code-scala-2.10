
import language.experimental.macros
import scala.reflect.runtime.{universe=>ru}
import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox

object RuntimeDuke {
  val toolbox = ru.runtimeMirror(getClass.getClassLoader).mkToolBox()
  import toolbox._

  def astPlus( x:Int, y:Int ) = {

    val tree = parse( s"($x + $y).toString")
    eval(tree)

  }

}
