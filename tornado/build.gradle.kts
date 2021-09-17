import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
}

group = "com.irondnb"
version = "1.0-SNAPSHOT"

val tornadofx_version: String by rootProject
val scarlet_version: String by rootProject

repositories {
    mavenCentral()
}

application {
    mainClassName = "com.example.MainKt"
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("com.tinder.scarlet:scarlet:$scarlet_version")
    implementation("com.tinder.scarlet:websocket-okhttp:$scarlet_version")
    implementation("com.tinder.scarlet:stream-adapter-rxjava2:$scarlet_version")
    implementation("com.tinder.scarlet:message-adapter-moshi:$scarlet_version")
    implementation("com.tinder.scarlet:stream-adapter-coroutines:$scarlet_version")
    implementation(kotlin("stdlib-jdk8"))
    implementation("no.tornado:tornadofx:$tornadofx_version")
    testImplementation(kotlin("test-junit"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}