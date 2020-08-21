package com.example.qutectest_yousuf.ui.home.model


import com.google.gson.annotations.SerializedName

data class HomeDataRP(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("Error")
    val error: Error,
    @SerializedName("Status")
    val status: String
)