name := """digitary"""
organization := "net.digitary.rest"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += "com.h2database" % "h2" % "1.4.194"
libraryDependencies ++= Seq(javaJpa, "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final")
libraryDependencies += "io.swagger" %% "swagger-play2" % "1.6.0"

PlayKeys.externalizeResources := false

