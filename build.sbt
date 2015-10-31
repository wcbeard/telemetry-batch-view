// name := "telemetry-parquet-converter"
// version := "1.0"
// scalaVersion := "2.11.6"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

lazy val root = (project in file(".")).
  settings(
    name := "telemetry-parquet-converter",
    version := "1.0",
    scalaVersion := "2.11.7",
    retrieveManaged := true,
    libraryDependencies += "org.apache.avro" % "avro" % "1.7.7",
    libraryDependencies += "org.apache.parquet" % "parquet-avro" % "1.8.1",
    libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.6.1",
    libraryDependencies += "com.github.seratch" %% "awscala" % "0.5.+",
    libraryDependencies += "net.sandrogrzicic" %% "scalabuff-runtime" % "1.4.0",
    libraryDependencies += "com.typesafe" % "config" % "1.2.1",
    libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.0.0",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "1.0.0",
    libraryDependencies += "org.xerial.snappy" % "snappy-java" % "1.1.2",
    libraryDependencies += "org.json4s" %% "json4s-native" % "3.3.0",
    libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.4.0"
  )

assemblyJarName in assembly := "telemetry-parquet-converter.jar"
test in assembly := {}

mergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
