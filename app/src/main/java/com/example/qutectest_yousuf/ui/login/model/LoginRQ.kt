package com.example.qutectest_yousuf.ui.login.model


import com.google.gson.annotations.SerializedName

data class LoginRQ(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)