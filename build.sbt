
lazy val root= (project in file(".")).
  settings(
    name := "hellojs",
    version := "1.0",
    scalaVersion := "2.11.7"
  ).
  enablePlugins(ScalaJSPlugin)
