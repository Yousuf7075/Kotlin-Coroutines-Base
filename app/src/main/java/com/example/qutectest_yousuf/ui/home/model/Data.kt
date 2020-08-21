package com.example.qutectest_yousuf.ui.home.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("area_id")
    val areaId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("questions")
    val questions: List<Question>,
    @SerializedName("survey_area")
    val surveyArea: String,
    @SerializedName("survey_date")
    val surveyDate: String,
    @SerializedName("title")
    val title: String
)