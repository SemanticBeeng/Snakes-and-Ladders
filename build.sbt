name := "scala-python"

scalaVersion in ThisBuild := "2.11.8"

scalacOptions in ThisBuild += "-feature"

lazy val scalaPython = (project in file("."))
	.dependsOn(python_hosting_scala, scala_hosting_python, language_neutral)

lazy val python_hosting_scala = (project in file("python_hosting_scala"))

lazy val scala_hosting_python = (project in file("scala_hosting_python"))

lazy val language_neutral = (project in file("language_neutral"))

resolvers += "bigtoast-github" at "http://bigtoast.github.com/repo/"

//unmanagedBase := baseDirectory.value / "lib"

libraryDependencies ++= {
  object Versions {
    final val spark       = "2.3.0"
    final val spec2       = "3.8.9"
    final val hadoop      = "2.7.4"
  }

  Seq(
    "org.apache.thrift"     %    "libthrift" % "0.11.0" pomOnly(),
    "org.specs2"             %% "specs2-core"          % Versions.spec2  % Test,
    "org.specs2"             %% "specs2-matcher-extra" % Versions.spec2  % Test,
    "org.specs2"             %% "specs2-scalacheck"    % Versions.spec2  % Test,
    "org.specs2"             %% "specs2-mock"          % Versions.spec2  % Test,
    "org.specs2"             %% "specs2-junit"         % Versions.spec2  % Test
  )
}

//--------------------------------
//---- sbt-assembly settings -----
//--------------------------------

val mainClassString = "DataConversion"

mainClass in assembly := Some(mainClassString)

assemblyJarName := "spark-app.jar"

assemblyMergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf")          => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$")      => MergeStrategy.discard
  case "log4j.properties"                                  => MergeStrategy.discard
  case m if m.toLowerCase.startsWith("meta-inf/services/") => MergeStrategy.filterDistinctLines
  case "reference.conf"                                    => MergeStrategy.concat
  case _                                                   => MergeStrategy.first
}

assemblyOption in assembly ~= { _.copy(cacheOutput = false) }

assemblyExcludedJars in assembly := {
  val cp = (fullClasspath in assembly).value
  cp filter { c =>
    c.data.getName.startsWith("log4j")
    c.data.getName.startsWith("slf4j-") ||
    c.data.getName.startsWith("scala-library")
  }
}

// Disable tests (they require Spark)
test in assembly := {}

// publish to artifacts directory
publishArtifact in(Compile, packageDoc) := false

publishTo := Some(Resolver.file("file", new File("artifacts")))

cleanFiles += baseDirectory { base => base / "artifacts" }.value
