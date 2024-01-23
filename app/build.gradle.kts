plugins {
    id("java")
    id("application")
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

    //testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    //testImplementation(platform("org.junit:junit-bom:5.9.1"))
    //testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass = "hexlet.code.App"
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.9.3")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(20);
    }
}

tasks.test {
//    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.jacocoTestReport {
    reports {
        html.required = true
    }
}
