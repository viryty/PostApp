package com.convertmax.android.postapp.data.post.list.retrofit

import com.convertmax.android.postapp.data.post.list.PostListRemoteDataSource
import com.convertmax.android.postapp.data.post.remote.Post
import com.convertmax.android.postapp.data.post.remote.PostApi

class RetrofitPostListDataSource (
    private val postApi: PostApi
) : PostListRemoteDataSource {
    override suspend fun getPosts(): List<Post> = postApi.getPosts()
}