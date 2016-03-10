
name := "Algorithm Project"

logLevel := Level.Debug

lazy val root= (project in file(".")).
  aggregate(js, jvm).
  settings(
  )

lazy val alg = crossProject.in(file(".")).
  settings(
    name := "algo",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.11.7"
  ).
  jvmSettings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.0-M15" % "test"
    )
  ).
  jsSettings(
    resolvers += "amateras-repo" at "http://amateras.sourceforge.jp/mvn/",
    libraryDependencies ++= Seq(
      "org.scalatest" %%% "scalatest" % "3.0.0-M15" % "test"
    )
  )

lazy val jvm = alg.jvm
lazy val js = alg.js
