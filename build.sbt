name := "solr-scala-client"

organization := "be.avhconsult"

version := "0.0.13-SNAPSHOT"

scalaVersion := "2.11.7"

scalacOptions += "-feature"

resolvers ++= Seq("snapshots-repo" at "http://scala-tools.org/repo-snapshots")

libraryDependencies ++= Seq(
  "org.apache.solr" % "solr-solrj" % "6.1.0" % "compile",
  "com.ning" % "async-http-client" % "1.7.16" % "compile",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  "org.mockito" % "mockito-core" % "1.9.0" % "test",
  "commons-logging" % "commons-logging" % "1.1.3" % "runtime"
)

publishTo <<= version { v: String =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else                             Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

pomExtra := (
    <scm>
      <url>git@github.com:alexandervanhecke/solr-scala-client.git</url>
      <connection>scm:git:git@github.com:alexandervanhecke/solr-scala-client.git</connection>
    </scm>
  )