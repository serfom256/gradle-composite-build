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
        create("extlibs") {
            from("org.extlib:ext-lib:latest")
            // from(files("../ext-lib/gradle/libs.versions.toml")) - if you want to import it from local file
        }
    }
}