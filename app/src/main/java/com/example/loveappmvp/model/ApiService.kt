package com.example.loveappmvp.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("x-rapidapi-key") key: String,
        @Header("x-rapidapi-host") host: String,
    ): Call<CalculateResult>
}
//val client = OkHttpClient()
//
//val request = Request.Builder()
//    .url("https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John")
//    .get()
//    .addHeader("x-rapidapi-key", "9ab403d45bmsh5e7a6133bc1029dp102882jsnd6462fe926c0")
//    .addHeader("x-rapidapi-host", "love-calculator.p.rapidapi.com")
//    .build()
//
//val response = client.newCall(request).execute()