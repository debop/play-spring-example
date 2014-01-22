import play.Project._

name := "play2-spring"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
    jdbc,
    cache,
    /* Spring framework 4.0이상에서는 org.ow2.asm 4.2 버전을 사용해야 합니다. */
    "org.ow2.asm" % "asm-all" % "4.2",
    "kr.debop4s" % "debop4s-core" % "1.0-SNAPSHOT",
    "kr.debop4s" % "debop4s-data" % "1.0-SNAPSHOT"
)

resolvers += "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository"

resolvers += "JBoss repository" at "https://repository.jboss.org/nexus/content/repositories"

resolvers += "Spring repository" at "http://maven.springframework.org/release"

transitiveClassifiers := Seq("sources")

play.Project.playScalaSettings

scalaVersion := "2.10.3"
