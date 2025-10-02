rootProject.name="gradle-composite-build"
includeBuild("my-app")
includeBuild("my-lib")
includeBuild("plugins/license-plugin")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS") // for type safe dependencies like implementation(extlibs.commons.lang3)

println("BUILD STEP 1: Initialization phase")