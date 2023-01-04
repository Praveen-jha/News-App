package com.mr_praveen_jha_.newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

   companion object {
       val newsInstance: NewsInterface
       init {
           val retrofit = Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
           newsInstance = retrofit.create(NewsInterface::class.java)
       }

    }
}