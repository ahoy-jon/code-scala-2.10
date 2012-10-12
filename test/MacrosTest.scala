import org.junit.Test


class MacrosTest {
  import MacrosDuke._

  @Test
  def desugarTest() {
    println(desugar((1 to 10).map(_ + 1)))

    println(desugar((_:String) => {
      println("ahoy")
      "duke"
    }))
  }

  @Test
  def logIsAllMyLife() {
    val plouf =

    log(log("plouf".toUpperCase).contains("P"))
  }

  @Test
  def binaryDude() {

    println(b"010011")
  }

  }