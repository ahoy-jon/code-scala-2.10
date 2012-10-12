
import language.dynamics

case class DynamicDuke(name:String) extends Dynamic {
  
  def applyDynamic(method:String, args: Any*) : String = {
    "Hello Duke" + args
  }

  def selectDynamic(method:String): String= {
     method + " Duke"
  }

}

