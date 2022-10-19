# KtorClient

## Why Ktor on client-side?
for KMM we don't use java libraries (eg. retrofit + okhttp)

## Setup
### Add Dependencies and Permissions
add internet permission in `AndroidManifest.xml`. *required to make HTTP requests to the API*
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

in `build.gradle(:app)`
```gradle
dependencies {
    ...
    def ktor_version = "1.6.3"
    // adds Ktor's core components to our project.
    implementation "io.ktor:ktor-client-core:$ktor_version"
    
    // HTTP engine: The HTTP client used to perform network requests, for iOS, we would use an iOS dependency.
    implementation "io.ktor:ktor-client-android:$ktor_version"
    
    // convert objects to and from JSON.
    implementation "io.ktor:ktor-client-serialization:$ktor_version"
    
    //Logging
    implementation "io.ktor:ktor-client-logging:$ktor_version"
    // allows us to see nicely formatted logs in a console.
    implementation "ch.qos.logback:logback-classic:1.2.3"

    // provides a convenient mechanism for converting Kotlin objects into a serialized form like JSON, and vice vers
    implementation "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0"
}

```
apply plugin for `kotlinx-serialization`
```gradle
plugins {
    ...
    id 'org.jetbrains.kotlin.plugin.serialization'
    ...
}
```
add classpath in `build.gradle` project file
```gradle
dependencies {
        classpath "org.jetbrains.kotlin:kotlin-serialization:1.5.21"
}
```
