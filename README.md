# KtorClient

## Why Ktor on client-side?
for KMM we don't use java libraries (eg. retrofit + okhttp)

## Setup
### Add Dependencies
on `build.gradle(:app)`
```gradle
dependencies {
    ...
    def ktor_version = "1.6.3"
    // adds Ktor's core components to our project.
    implementation "io.ktor:ktor-client-core:$ktor_version"
    implementation "io.ktor:ktor-client-android:$ktor_version"
    implementation "io.ktor:ktor-client-serialization:$ktor_version"
    implementation "io.ktor:ktor-client-logging:$ktor_version"
    // allows us to see nicely formatted logs in a console.
    implementation "ch.qos.logback:logback-classic:1.2.3"

    // provides a convenient mechanism for converting Kotlin objects into a serialized form like JSON, and vice vers
    implementation "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0"
}

```
apply plugin for `kotlin-serialization`
```gradle
plugins {
    ...
    id 'org.jetbrains.kotlin.plugin.serialization'
    ...
}
```
