name := "solr-scala-client"

organization := "be.avhconsult"

version := "0.0.14-SNAPSHOT"

scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.11.7", "2.12.0-M5")

scalacOptions += "-feature"

libraryDependencies ++= Seq(
  "org.apache.solr" % "solr-solrj" % "6.1.0" % "compile",
  "com.ning" % "async-http-client" % "1.7.16" % "compile",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.mockito" % "mockito-core" % "1.9.0" % "test",
  "commons-logging" % "commons-logging" % "1.1.3" % "runtime"
)

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

licenses := Seq("The Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/alexandervanhecke/solr-scala-client"))

pomExtra := (
    <developers>
      <developer>
        <name>Alexander Van Hecke</name>
        <organization>AVH Consult</organization>
        <organizationUrl>https://github.com/alexandervanhecke</organizationUrl>
      </developer>
    </developers>
    <scm>
      <connection>scm:git:git://github.com/alexandervanhecke/solr-scala-client.git</connection>
      <developerConnection>scm:git:ssh://github.com:alexandervanhecke/solr-scala-client.git</developerConnection>
      <url>http://github.com/alexandervanhecke/solr-scala-client/tree/master</url>
    </scm>
  )