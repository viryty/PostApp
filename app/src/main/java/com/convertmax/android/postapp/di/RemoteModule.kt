package com.convertmax.android.postapp.di

import com.convertmax.android.postapp.data.post.remote.PostApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providePostApi(retrofit: Retrofit): PostApi =
        retrofit.create(PostApi::class.java)
}