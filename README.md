# This is the simple tutorial that shows how to organize composite project with gradle

### Project structure
```
├── ext-lib # library from external repository
│   ├── ext-lib # module, that will be published as a platform
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
│   │                   └── sample
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
│                       └── sample
│                           └── stringutils
│                               └── Strings.java
├── README.md
└── settings.gradle.kts
```

main application `:my-app:app` includes :
- :my-app:api
- :my-lib:number-utils
- :my-lib:string-utils
- ext-lib(from external repository like ~/.m2)

---

### Project set up
Requirements:
- Java 17 +
- gradle 8.13 +

Also you need to publish `:ext-lib` to local maven repository(~/.m2): `gradle :ext-lib:publishToMavenLocal`

### How to run main app with external dependencies:
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