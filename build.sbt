organization := "org.scala-lang"

name := "scala-partest-interface"

version := "0.1"

scalaVersion := "2.11.0-M4"

scalaBinaryVersion := scalaVersion.value

libraryDependencies += "org.scala-sbt" % "test-interface" % "1.0"


// maven publishing
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://www.scala-lang.org/</url>
  <inceptionYear>2002</inceptionYear>
  <licenses>
    <license>
      <name>BSD-like</name>
      <url>http://www.scala-lang.org/downloads/license.html
      </url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <connection>scm:git:git://github.com/scala/scala-partest-interface.git</connection>
    <url>https://github.com/scala/scala-partest-interface</url>
  </scm>
  <issueManagement>
    <system>JIRA</system>
    <url>https://issues.scala-lang.org/</url>
  </issueManagement>
  <developers>
    <developer>
      <id>lamp</id>
      <name>EPFL LAMP</name>
    </developer>
    <developer>
      <id>Typesafe</id>
      <name>Typesafe, Inc.</name>
    </developer>
  </developers>
)
