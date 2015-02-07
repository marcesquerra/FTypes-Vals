organization := "com.bryghts.ftypes"

scalaVersion := "2.10.3"

name := "FTypes"

scalaVersion := "2.11.5"

publishMavenStyle := true

publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
    else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomExtra := (
    <url>http://www.brights.com</url>
        <licenses>
            <license>
                <name>mit</name>
            </license>
        </licenses>
        <scm>
            <url>git@github.com:marcesquerra/KissJson.git</url>
            <connection>scm:git:git@github.com:marcesquerra/KissJson.git</connection>
        </scm>
        <developers>
            <developer>
                <name>Marc Esquerrà i Bayo</name>
                <email>esquerra@bryghts.com</email>
            </developer>
        </developers>
    )

