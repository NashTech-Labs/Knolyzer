import sbt._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.knoldus"
ThisBuild / organizationName := "knoldus"

lazy val root = (project in file("."))
  .settings(
    name := "knolyzer",
    libraryDependencies += scalaTest
  )

lazy val common = project in file("common")

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.7" % Test
