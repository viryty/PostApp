package com.convertmax.android.postapp.data.post.list

import com.convertmax.android.postapp.data.post.list.retrofit.RetrofitPostListDataSource
import com.convertmax.android.postapp.data.post.remote.PostApi
import dagger.Module
import dagger.Provides

@Module
class PostListModule {

    @Provides
    fun providePostListRemoteDataSource(postApi: PostApi): PostListRemoteDataSource =
        RetrofitPostListDataSource(postApi)

    @Provides
    fun providePostListRepository(remote: PostListRemoteDataSource): PostListRepository =
        PostListRepository(remote)
}