package com.convertmax.android.postapp.data.post.remote

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun getPosts(): Flow<List<Post>>
}