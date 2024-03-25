package com.convertmax.android.postapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.convertmax.android.postapp.data.post.list.PostListRepository
import com.convertmax.android.postapp.data.post.remote.Post
import com.convertmax.android.postapp.data.post.remote.PostApiState
import com.convertmax.android.postapp.data.post.remote.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val repository: PostListRepository
): ViewModel() {

    val postState = MutableStateFlow(
        PostApiState(
            Status.LOADING,
            listOf<Post>(),
            ""
        )
    )

    init {
        getPosts()
    }

    fun getPosts() {
        postState.value = PostApiState.loading()

        viewModelScope.launch {
            repository.getPosts()
                .catch {
                    postState.value = PostApiState.error(it.message.toString())
                }
                .collect {
                    postState.value = PostApiState.success(it.data)
                }
        }
    }

}