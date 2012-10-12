import org.junit.Test

import MyMacros._

class DynamicTest {

  @Test
  def ahoy() {
    val myDynamicStuff = MyDynamic("ahoy")
    assert(myDynamicStuff.ahoy == "ahoy Duke")
    assert(myDynamicStuff.plouf == "plouf Duke")
    //println(MyDynamicStuff.ahoy("Today is a good day !!"))
  }

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