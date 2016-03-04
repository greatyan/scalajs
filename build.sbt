//lazy val libraries = Seq(
//    "org.scala-js" %%% "scalajs-dom" % "0.9.0",
//    "be.doeraene" %%% "scalajs-jquery" % "0.9.0"
//  )

lazy val root= (project in file(".")).
  settings(
    name := "hellojs",
    version := "1.0",
    scalaVersion := "2.11.7",
    resolvers += "amateras-repo" at "http://amateras.sourceforge.jp/mvn/",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.0",
      "be.doeraene" %%% "scalajs-jquery" % "0.9.0",
      "org.scalatest" %%% "scalatest" % "3.0.0-M15" % "test",
      "com.scalawarrior" %%% "scalajs-ace" % "0.0.2" 
    ),
    skip in packageJSDependencies := false,
    jsDependencies ++= Seq(
      "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js",
      RuntimeDOM
     )
  ).
  enablePlugins(ScalaJSPlugin)

