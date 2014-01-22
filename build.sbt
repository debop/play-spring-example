import play.Project._

name := "play2-spring"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
    jdbc,
    cache,
    "asm" % "asm" % "3.3.1" % "provided",
    "org.springframework" % "spring-core" % "4.0.0.RELEASE" exclude("org.objectweb.asm", "objectweb.asm"),
    "kr.debop4s" % "debop4s-core" % "1.0-SNAPSHOT",
    "kr.debop4s" % "debop4s-data" % "1.0-SNAPSHOT"
)

resolvers += "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository"

resolvers += "JBoss repository" at "https://repository.jboss.org/nexus/content/repositories"

resolvers += "Spring repository" at "http://maven.springframework.org/release"

transitiveClassifiers := Seq("sources")

play.Project.playScalaSettings

scalaVersion := "2.10.3"
