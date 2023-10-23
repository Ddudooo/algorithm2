plugins {
    kotlin("jvm") version "1.9.0"
}

group = "study.algorithm2.leetcode.medium.out_of_boundary_paths"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}