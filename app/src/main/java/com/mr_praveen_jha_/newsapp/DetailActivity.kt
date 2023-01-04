package com.mr_praveen_jha_.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val url : String? = intent.getStringExtra("URL")

     if (url != null){
         detailWebView.settings.javaScriptEnabled = true
         detailWebView.settings.userAgentString = "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1"
         detailWebView.webViewClient = object : WebViewClient(){
             override fun onPageFinished(view: WebView?, url: String?) {
                 super.onPageFinished(view, url)
                 progressBar.visibility = View.GONE
                 detailWebView.visibility = View.VISIBLE
             }
         }
         detailWebView.loadUrl(url)
     }
    }
}