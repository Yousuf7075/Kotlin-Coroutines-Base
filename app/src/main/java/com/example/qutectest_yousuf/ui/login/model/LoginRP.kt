package com.example.qutectest_yousuf.ui.login.model


import com.google.gson.annotations.SerializedName

data class LoginRP(
    @SerializedName("active_status")
    val activeStatus: String,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("surveyor_id ")
    val surveyorId: Int,
    @SerializedName("token")
    val token: String
)