package com.convertmax.android.postapp.data.post.remote

import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    suspend fun getPosts(): List<Post>
}