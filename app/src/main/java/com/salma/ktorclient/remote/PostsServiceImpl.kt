package com.salma.ktorclient.remote

import com.salma.ktorclient.remote.data.dto.PostRequest
import com.salma.ktorclient.remote.data.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class PostsServiceImpl(
    private val client: HttpClient,
) : PostsService {
    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get {
                url(HttpRoutes.POSTS)
            }
        } catch (e: RedirectResponseException) {
            // 3xx
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            // 4xx
            println("Error: ${e.response.status.description}")

            emptyList()
        } catch (e: ServerResponseException) {
            // 5xx
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return try {
            // post<return type>
            client.post<PostResponse>() {
                url(HttpRoutes.POSTS)
                //attach header
                contentType(ContentType.Application.Json)
                body = postRequest.body
            }
        } catch (e: RedirectResponseException) {
            // 3xx
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            // 4xx
            println("Error: ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            // 5xx
            println("Error: ${e.response.status.description}")
            null
        } catch (e: Exception) {
            println("Error: ${e.message}")
            null
        }
    }
}