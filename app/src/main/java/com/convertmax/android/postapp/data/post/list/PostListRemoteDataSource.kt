package com.convertmax.android.postapp.data.post.list

import com.convertmax.android.postapp.data.post.remote.Post
import kotlinx.coroutines.flow.Flow

interface PostListRemoteDataSource {
    fun getPosts(): Flow<List<Post>>
}