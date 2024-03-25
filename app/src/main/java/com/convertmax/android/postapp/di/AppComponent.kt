package com.convertmax.android.postapp.di

import com.convertmax.android.postapp.data.post.list.PostListModule
import com.convertmax.android.postapp.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RemoteModule::class, PostListModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}