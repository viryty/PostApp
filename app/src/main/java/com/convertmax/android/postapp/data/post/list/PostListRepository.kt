package com.convertmax.android.postapp.data.post.list

import com.convertmax.android.postapp.data.post.remote.Post
import kotlinx.coroutines.flow.Flow

class PostListRepository (
    private val remoteDataSource: PostListRemoteDataSource
) {
    fun getPosts(): Flow<List<Post>> = remoteDataSource.getPosts()
}