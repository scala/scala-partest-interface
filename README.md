scala-partest-interface
=======================

SBT interface to partest

To `sbt test` your project with [partest](https://github.com/scala/scala-partest) through this testing interface,
add something like this to your `build.sbt`:

```
// for testing with partest
libraryDependencies += "org.scala-lang.modules" %% "scala-partest-interface" % "0.2" % "test"

// the actual partest the interface calls into -- must be binary version close enough to ours
// so that it can link to the compiler/lib we're using (testing)
libraryDependencies += "org.scala-lang.modules" %% "scala-partest" % "1.0-RC2" % "test"

fork in Test := true

javaOptions in Test += "-Xmx1G"

testFrameworks += new TestFramework("scala.tools.partest.Framework")

definedTests in Test += (
  new sbt.TestDefinition(
    "partest",
    // marker fingerprint since there are no test classes
    // to be discovered by sbt:
    new sbt.testing.AnnotatedFingerprint {
      def isModule = true
      def annotationName = "partest"
    }, true, Array())
  )
```

SBT's `test` task will now see a test with the fingerprint that matches
the fingerprint in the array of fingerprints (tests, really) returned by
`scala.tools.partest.Framework::fingerprints`.

The testing interface unfortunately hardcodes fingerprint matching,
so I don't see how else to shoehorn partest into this approach.
