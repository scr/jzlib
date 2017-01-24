version in Global := "1.1.3"
scalaVersion in Global := "2.12.1"
crossPaths in Global := false
autoScalaLibrary in Global := false

(libraryDependencies in Global) ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test")

val jzlib = project in file(".")

val example = project
  .dependsOn(jzlib)