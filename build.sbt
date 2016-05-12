name := "scratch4s"

version := "1.0"

scalaVersion := "2.11.8"

val http4sVersion = "0.13.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test" withSources(),

  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,

  "ch.qos.logback" % "logback-classic" % "1.0.3"
)