
lazy val root= (project in file(".")).
  settings(
    name := "hellojs",
    version := "1.0",
    scalaVersion := "2.11.7",
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0"
  ).
  enablePlugins(ScalaJSPlugin)
