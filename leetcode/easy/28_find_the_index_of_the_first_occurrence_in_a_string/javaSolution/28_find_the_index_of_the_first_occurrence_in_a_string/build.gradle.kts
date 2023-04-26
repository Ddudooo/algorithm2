plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.10"

    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")

    testImplementation("io.kotest:kotest-assertions-core:5.6.1")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.6.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("study.algorithm.leetcode.easy.problem_28.AppKt")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
