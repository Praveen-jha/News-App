package com.mr_praveen_jha_.newsapp


import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.Response


const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "65d8647429c5489185a466b568405677"

interface NewsInterface{

    @GET("/v2/top-headlines?apikey=$API_KEY")
    fun getHeadLines(
        @Query("country") country : String,
        @Query("page") page:Int
    ):Call<NewsResponse>
}