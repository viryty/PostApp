package com.convertmax.android.postapp.data.post.list

import com.convertmax.android.postapp.data.post.remote.Post

interface PostListRemoteDataSource {
    suspend fun getPosts(): List<Post>
}