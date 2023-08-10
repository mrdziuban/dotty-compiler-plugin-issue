lazy val baseSettings = Seq(
  organization := "com.example",
  scalaVersion := "3.3.0",
  version      := "0.1.0-SNAPSHOT",
)

lazy val plugin = project.in(file("."))
  .settings(baseSettings)
  .settings(
    name := "example-compiler-plugin",
    libraryDependencies += "org.scala-lang" %% "scala3-compiler" % scalaVersion.value % "provided",
  )

lazy val tests = project.in(file("tests"))
  .settings(baseSettings)
  .settings(
    name := "example-compiler-plugin-tests",
    scalacOptions ++= {
      val jar = (plugin / Compile / Keys.`package`).value
      Seq(
        s"-Xplugin:${jar.getAbsolutePath}",
        s"-Jdummy=${jar.lastModified}",
      )
    },
  )
