package com.convertmax.android.postapp.data.post.remote

data class PostApiState<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {

    companion object {
        fun <T> success(data: T?): PostApiState<T> =
            PostApiState(Status.SUCCESS, data, null)

        fun <T> error(msg: String): PostApiState<T> =
            PostApiState(Status.ERROR, null, msg)

        fun <T> loading(): PostApiState<T> =
            PostApiState(Status.LOADING, null, null)
    }
}


