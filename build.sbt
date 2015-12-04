scalaModuleSettings

version                    := "0.8.0-SNAPSHOT"

crossScalaVersions         := {
  val java = System.getProperty("java.version")
  if (java.startsWith("1.6."))
    Seq("2.11.7")
  else if (java.startsWith("1.8."))
    Seq("2.12.0-M3")
  else
    sys.error(s"don't know what Scala versions to build on $java")
}

scalaVersion               := crossScalaVersions.value.head

snapshotScalaBinaryVersion := scalaVersion.value

// dependencies:
libraryDependencies        += "org.scala-sbt" % "test-interface" % "1.0"

//sbt-mima-pluginname       := "scala-partest-interface"
