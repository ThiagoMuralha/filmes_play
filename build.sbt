name := """filmes"""

version := "1.0-SNAPSHOT"

<<<<<<< HEAD
lazy val root = (project in file(".")).enablePlugins(PlayJava)
=======
lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)
>>>>>>> 522874cc3a8dd6721b78352338112bf6bf09d8ba

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
	javaJdbc,
	cache,
	javaWs,
	"javax.persistence" % "persistence-api" % "1.0.2",
	"mysql" % "mysql-connector-java" % "5.1.38"
)
