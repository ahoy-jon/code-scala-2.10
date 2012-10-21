
import scala.reflect.macros.Context
import language.experimental.macros
import scala.language.implicitConversions

object MacrosDuke {
def desugar(a: Any): String = macro desugarImpl

def desugarImpl(c: Context)(a: c.Expr[Any]) = {
  import c.universe._

  val s = show(a.tree)
  c.Expr(
    Literal(Constant(s))
  )
}


  def log[A](a: A): A = macro logImpl[A]

  def logImpl[A: c.WeakTypeTag](c: Context)(a: c.Expr[A]): c.Expr[A] = {
    import c.universe._
    val aCode = c.Expr[String](Literal(Constant(show(a.tree))))
    c.universe.reify {
      val result = a.splice
      println(aCode.splice + " = " + result)
      result
    }
  }



  implicit def enrichStringContext(sc: StringContext) = new RichStringContext(sc)

  class RichStringContext(sc: StringContext) {
    // This is how a non-macro version would be implemented.
    // def b() = {
    //   val s = sc.parts.mkString
    //   parseBinary(s).getOrElse(sys.error("invalid binary literal: " + s))
    // }

    /** Binary literal integer
      *
      *  {{{
      *  scala> b"101010"
      *  res0: Int = 42
      *  }}}
      */
    def b(): Int = macro bImpl
  }

  def b(): Int = macro bImpl
  def bImpl(c: Context)(): c.Expr[Int] = {
    def parseBinary(s: String): Int = {
      var i = s.length - 1
      var sum = 0
      var mult = 1
      while (i >= 0) {
        s.charAt(i) match {
          case '1' => sum += mult
          case '0' =>
          case x =>
            c.abort(c.enclosingPosition, "invalid binary literal")
        }
        mult *= 2
        i -= 1
      }
      sum
    }

    import c.universe._

    val i = c.prefix.tree match {
      // e.g: `c.g.r.m.Macrocosm.enrichStringContext(scala.StringContext.apply("1111"))`
      case Apply(_, List(Apply(_, List(Literal(Constant(const: String)))))) =>
        parseBinary(const)
      case x =>
        c.abort(c.enclosingPosition, "unexpected tree: " + show(x))
    }
    c.Expr[Int](Literal(Constant(i)))
  }


}