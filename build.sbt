scalaVersion := "2.10.0-RC1"


scalaSource in Compile <<= baseDirectory(_ / "src")

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.10.0-RC1"
