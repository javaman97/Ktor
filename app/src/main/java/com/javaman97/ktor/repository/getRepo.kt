package com.javaman97.ktor.repository

import com.javaman97.ktor.network.KtorClient
import com.javaman97.ktor.network.model.Comment
import com.javaman97.ktor.network.model.Post
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse

class getRepo {

    suspend fun getPosts():List<Post> = KtorClient.httpClient.get("https://jsonplaceholder.typicode.com/posts")

    suspend fun  getComments(id:String):List<Comment> = KtorClient.httpClient.get<List<Comment>> {
        url("https://jsonplaceholder.typicode.com/posts/1/comments")
        parameter("postId",id)

    }

    suspend fun postPost(post: Post):Post = KtorClient.httpClient.post{
        url("https://jsonplaceholder.typicode.com/posts")
        body = post
    }

    suspend fun putPost(id:Int, post: Post):Post = KtorClient.httpClient.put{
        url("https://jsonplaceholder.typicode.com/posts/$id")
        body = post
    }

    suspend fun patchPost(id:Int, map:MutableMap<String, String>) =KtorClient.httpClient.patch<Post>{
        url("https://jsonplaceholder.typicode.com/posts/$id")
        body = map
    }
    suspend fun deletePost(id:Int):HttpResponse =
        KtorClient.httpClient.delete{
           url( "https://jsonplaceholder.typicode.com/posts/$id")
        }

}