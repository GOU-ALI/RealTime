ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.2"

lazy val root = (project in file("."))
  .settings(
    name := "RealTime"
  )
val sparkVersion = "3.5.0"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.5.0"

libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.20.0"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.20.0"


