//lazy val libraries = Seq(
//    "org.scala-js" %%% "scalajs-dom" % "0.9.0",
//    "be.doeraene" %%% "scalajs-jquery" % "0.9.0"
//  )

lazy val root= (project in file(".")).
  settings(
    name := "hellojs",
    version := "1.0",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.0",
      "be.doeraene" %%% "scalajs-jquery" % "0.9.0",
      "org.scalatest" %%% "scalatest" % "3.0.0-M15" % "test"
    ),
    skip in packageJSDependencies := false,
    jsDependencies ++= Seq(
      "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js",
      RuntimeDOM
     )
  ).
  enablePlugins(ScalaJSPlugin)

