package com.salma.ktorclient.remote

import com.salma.ktorclient.remote.data.dto.PostRequest
import com.salma.ktorclient.remote.data.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface PostsService {
    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest): PostResponse?

    companion object {
        fun create(): PostsService {
            return PostsServiceImpl(
                client = HttpClient(
                    Android
                ) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    // required
                    install(JsonFeature) {
                        // assign serializer (with with library)
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}