plugins {
    kotlin("jvm") version "2.2.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-assertions-core:6.0.7")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}