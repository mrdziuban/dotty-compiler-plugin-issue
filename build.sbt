lazy val plugin = project.in(file("."))
  .settings(
    name := "example-compiler-plugin",
    organization := "com.example",
    scalaVersion := "3.3.0",
    version      := "0.1.0-SNAPSHOT",
    libraryDependencies += "org.scala-lang" %% "scala3-compiler" % scalaVersion.value % "provided",
  )
