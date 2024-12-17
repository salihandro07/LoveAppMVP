package com.example.loveappmvp.model

import com.google.gson.annotations.SerializedName

data class CalculateResult(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("result")
    val result: String
)
