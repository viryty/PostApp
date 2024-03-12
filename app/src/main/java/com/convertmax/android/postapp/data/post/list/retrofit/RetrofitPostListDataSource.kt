package com.convertmax.android.postapp.data.post.list.retrofit

import com.convertmax.android.postapp.data.post.list.PostListRemoteDataSource
import com.convertmax.android.postapp.data.post.remote.Post
import com.convertmax.android.postapp.data.post.remote.PostApi
import kotlinx.coroutines.flow.Flow

class RetrofitPostListDataSource (
    private val postApi: PostApi
) : PostListRemoteDataSource {
    override fun getPosts(): Flow<List<Post>> = postApi.getPosts()
}