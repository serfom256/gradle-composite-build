rootProject.name="my-app"
include(":app")
include(":api")

pluginManagement { // used for plugin resolution
    includeBuild("../plugins/license-plugin")
}

dependencyResolutionManagement { // external platform consumption
    repositories {
        mavenLocal()
    }
    versionCatalogs {
        create("platform") {
            from("org.extlib:ext-platform:latest")
            // from(files("../ext-lib-platform/gradle/libs.versions.toml")) - if you want to import platform(bom) from local file
        }
    }
}