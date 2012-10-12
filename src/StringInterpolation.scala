

object MyStringApp extends App {
  
  case class Personne(nom : String, age: Int)

  val duke = Personne("Duke", 25)

  val bonjour = s"Ahoy ${duke.nom.toUpperCase} !"
  
  println(bonjour)

}
