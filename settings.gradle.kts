rootProject.name="my-composite"
includeBuild("my-app")
includeBuild("my-lib")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS") // for type safe dependencies like implementation(extlibs.commons.lang3)
