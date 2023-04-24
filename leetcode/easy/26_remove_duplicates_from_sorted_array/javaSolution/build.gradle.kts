plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("com.diffplug.spotless") version "6.18.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")

    testImplementation("io.kotest:kotest-runner-junit5:5.6.1")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}



spotless {
    kotlin {
        ktlint("0.48.2")
            .setUseExperimental(true)
            .setEditorConfigPath("${project.rootProject.projectDir}/.editorconfig")

    }
    kotlinGradle {
        ktlint("0.48.2")
            .setUseExperimental(true)
            .setEditorConfigPath("${project.rootProject.projectDir}/.editorconfig")

    }
}
