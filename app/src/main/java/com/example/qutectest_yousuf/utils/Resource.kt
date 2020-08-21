package com.example.qutectest_yousuf.utils

class Resource<T>(val status: AuthStatus, val data: T?, val message: String?) {

    enum class AuthStatus {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        @JvmStatic
        fun <T> authenticated(data: T?): Resource<T> {
            return Resource(
                AuthStatus.SUCCESS,
                data,
                null
            )
        }

        @JvmStatic
        fun <T> error(msg: String?,data: T?): Resource<T> {
            return Resource(
                AuthStatus.ERROR,
                data,
                msg
            )
        }

        @JvmStatic
        fun <T> loading(data: T?): Resource<T> {
            return Resource(
                AuthStatus.LOADING,
                data,
                null
            )
        }

    }

}

