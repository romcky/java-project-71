plugins {
    application
    checkstyle
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.3")
}

application {
    mainClass = "hexlet.code.App"
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(20);
    }
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.jacocoTestReport {
    reports {
        html.required = true
        xml.required = true
    }
}
