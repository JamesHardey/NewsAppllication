package com.example.newapp.ui.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.newapp.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleBinding
    private lateinit var link: String
    private lateinit var webView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        link = intent.getStringExtra("link")!!
        binding = ActivityArticleBinding.inflate(layoutInflater)
        webView = binding.webView2
        if(link.isBlank()){
            link = "https://www.nytimes.com/"
        }
        webView.loadUrl(link)
        webView.settings.javaScriptEnabled = true
    }
}