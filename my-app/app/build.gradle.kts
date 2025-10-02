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
    implementation("org.sample.numberutils:number-utils:1.0")
    implementation("org.sample.stringutils:string-utils:1.0")
    implementation(extlibs.commons.lang3)
    implementation(projects.api)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.guava)
}

tasks.named<Test>("test") {
    useJUnitPlatform()                                              
}

println("BUILD STEP 2: Configuration phase")