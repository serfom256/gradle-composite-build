# This is the simple tutorial that shows how to organize composite project with gradle

## Project structure:
```
├── ext-lib-platform # library from external repository
│   ├── ext-platform # bill of material, that will be published as a platform
│   │   └── build.gradle.kts
│   ├── gradle
│   │   └── libs.versions.toml
│   ├── gradle.properties
│   └── settings.gradle.kts
│ 
│ 
│──────────────────────────────────────────────────
│ 
│ 
├── gradle # project dependencies
│   └── libs.versions.toml
│ 
│──────────────────────────────────────────────────
│ 
│ 
├── my-app # your application
│   ├── api # api module
│   │   ├── build.gradle.kts
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── org
│   │                   └── api
│   │                       └── Api.java
│   ├── app # main app module
│   │   ├── build.gradle.kts
│   │   └── src
│   │       ├── main
│   │       │   └── java
│   │       │       └── org
│   │       │           └── myapp
│   │       │               └── Main.java # main application
│   │       └── test
│   │           └── java
│   │               └── org
│   │                   └── myapp
│   │                       └── AppTest.java # application tests
│   ├── gradle # app libraries with versions
│   │   └── libs.versions.toml
│   └── settings.gradle.kts
│ 
│ 
│──────────────────────────────────────────────────
│ 
│ 
├── my-lib # in-project libraries
│   ├── number-utils # local library module 1
│   │   ├── build.gradle.kts
│   │   ├── gradle.properties
│   │   └── src
│   │       └── main
│   │           └── java
│   │               └── org
│   │                   └── utils
│   │                       └── numberutils
│   │                           └── Numbers.java
│   ├── settings.gradle.kts
│   └── string-utils # local library module 2
│       ├── build.gradle.kts
│       ├── gradle.properties
│       └── src
│           └── main
│               └── java
│                   └── org
│                       └── utils
│                           └── stringutils
│                               └── Strings.java
│
│
│──────────────────────────────────────────────────
│
│
├── plugins
│   └── license-plugin
│       ├── gradle
│       │   └── libs.versions.toml # plugin dependencies
│       ├── license-plugin # plugin, that inserts license into class header
│       │   ├── build.gradle.kts
│       │   └── src
│       │       ├── main
│       │          └── kotlin
│       │              └── org
│       │                  └── license
│       │                      └── LicensePlugin.kt
│       └── settings.gradle.kts
│
│
├── plugin-license.txt
├── README.md
└── settings.gradle.kts
```

main application `:my-app:app` includes :
- :my-app:api
- :my-lib:number-utils
- :my-lib:string-utils
- ext-lib-platform(from external repository like ~/.m2)

---

## Project set up:
Requirements:
- Java 17 +
- gradle 8.13 +

Also you need to publish `:ext-platform` to local maven repository(~/.m2): `cd ext-lib-platform && gradle :ext-platform:publishToMavenLocal`

## How to run main app with external dependencies:
```
gradle :my-app:app:run
```
After run the app, you’ll get an essentially identical output:
```
> Task :my-app:app:run
true
-497322403
6878f544-0371-4a67-8b74-3c01d8e76269
Api implementation called
```

---


## Plugins:

### License plugin
License inserts license text to java file header:
- add ```id("org.license")``` plugin into build script
- check license task is available: ```./gradlew :my-app:app:tasks```
- add license to project files: ```./gradlew :my-app:app:license```
