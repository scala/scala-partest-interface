organization := "org.scala-lang.modules"

name         := "scala-partest-interface"

version      := "0.2"

scalaVersion := "2.11.0-M7"

// don't use for doc scope, scaladoc warnings are not to be reckoned with
// "-Xfatal-warnings",
scalacOptions in compile ++= Seq("-optimize", "-feature", "-deprecation", "-unchecked", "-Xlint")

// dependencies:
libraryDependencies += "org.scala-sbt" % "test-interface" % "1.0"


// looking for boilerplate? we have it! (in standard.sbt)