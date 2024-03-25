package com.convertmax.android.postapp.data.post.list

import com.convertmax.android.postapp.data.post.remote.Post
import com.convertmax.android.postapp.data.post.remote.PostApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostListRepository (
    private val remoteDataSource: PostListRemoteDataSource
) {
    fun getPosts(): Flow<PostApiState<List<Post>>> =
        flow {
            emit(PostApiState.success(remoteDataSource.getPosts()))
        }.flowOn(Dispatchers.IO)
}