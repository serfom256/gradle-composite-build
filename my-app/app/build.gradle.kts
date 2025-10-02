plugins {
    `application`
    id("org.license")
}

repositories {
    mavenCentral()  
    mavenLocal()                                          
}

application {
    mainClass = "org.myapp.Main"
}
dependencies{
    implementation("org.utils.numberutils:number-utils:1.0")
    implementation("org.utils.stringutils:string-utils:1.0")
    implementation(platform.commons.lang3)
    implementation(projects.api)
    testImplementation(platform.junit.jupiter)
    testImplementation(platform.guava) // if you're using typesafe reference from local bom, it should looks like libs.your.dependency 
}

tasks.named<Test>("test") {
    useJUnitPlatform()                                              
}

println("BUILD STEP 2: Configuration phase")