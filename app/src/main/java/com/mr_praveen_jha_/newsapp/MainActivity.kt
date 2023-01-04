package com.mr_praveen_jha_.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter: NewsAdapter
    private  var articles = mutableListOf<Articles>()
    private var pageNumber = 1
    var totalResults = -1
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setRecyclerView()
        getNews()





    }

    private fun getNews() {
        val news = RetrofitInstance.newsInstance.getHeadLines("in", pageNumber)
        news.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                val news = response.body()
                if (news != null) {
                    totalResults = news.totalResults
                   articles.addAll(news.articles)
                    adapter.notifyDataSetChanged()

                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d("Praveen", "error in fetching news", t)
            }
        })
    }

    private fun setRecyclerView(){
        adapter = NewsAdapter(this@MainActivity,articles)
        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(this@MainActivity)

    }

}