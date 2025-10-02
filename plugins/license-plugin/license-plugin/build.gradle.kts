plugins {
    `java-gradle-plugin`
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
}

repositories {
    mavenCentral()
}
dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

gradlePlugin {
    val plugin by plugins.creating {
        id = "org.license"
        implementationClass = "org.license.LicensePlugin"
    }
}