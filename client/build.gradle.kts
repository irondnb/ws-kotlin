plugins {
    kotlin("jvm") version "1.5.20"
}

group = "com.irondnb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val ktor_version: String by project

dependencies {
    implementation("io.ktor:ktor-client-websockets:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("no.tornado:tornadofx:$ktor_version")

}