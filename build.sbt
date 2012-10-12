scalaVersion := "2.10.0-RC1"


scalaSource in Compile <<= baseDirectory(_ / "src")

scalaSource in Test <<= baseDirectory(_ / "test")

libraryDependencies += "com.novocode" % "junit-interface" % "0.10-M1" % "test"


libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.10.0-RC1"
