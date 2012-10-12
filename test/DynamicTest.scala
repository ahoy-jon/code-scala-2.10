import org.junit.Test


class DynamicTest {

  @Test
  def ahoy() {
    val duke = DynamicDuke("ahoy")
    assert(duke.ahoy == "ahoy Duke")
    assert(duke.plouf == "plouf Duke")
  }

}