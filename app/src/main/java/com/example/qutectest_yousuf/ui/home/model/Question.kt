package com.example.qutectest_yousuf.ui.home.model


import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("id")
    val id: Int,
    @SerializedName("options")
    val options: List<Any>,
    @SerializedName("title")
    val title: String,
    @SerializedName("view_type")
    val viewType: String
)