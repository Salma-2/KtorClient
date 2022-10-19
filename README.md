# KtorClient

## Why Ktor on client-side?
Ktor is built on Kotlin multi-platform mobile (KMM). 
This means you can create both iOS and Android applications with Kotlin and share a huge part of Kotlin code for both platforms.

## Add Dependencies and Permissions
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

### Setup the data models
- A model is a data transfer object(dto). It has data classes that represent what we get from an API.
- inside `remote.data.dto` package create new data class called `PostResponse`, and create another one for requests.
- we'll get data from this [API](https://jsonplaceholder.typicode.com)

Here's how the PostResponse will look like:
```kotlin
@Serializable
data class PostResponse(
    val body: String,
    val title: String,
    val id: Int,
    val userId: Int,
)
```

### Setup the API
1. setup the api endpoint
- create a new Kotlin Object file named HttpRoutes 
```kotlin
object HttpRoutes {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    const val POSTS = "$BASE_URL/posts"
}
```

2. define which functions we need to access the endpoints.
- create `PostsService` interface that will have mainly 2 functions (`getPosts()` and `createPost(postRequest)`)
- create `PostsServiceImpl` to implement the actual network call using the Ktor client [Impl](https://github.com/Salma-2/KtorClient/blob/master/app/src/main/java/com/salma/ktorclient/remote/PostsServiceImpl.kt)




[Reference](https://www.section.io/engineering-education/making-http-requests-with-ktor-in-android/)
