package com.example.appdinossauro


import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class DinoActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dinolayout)

        webView = findViewById(R.id.webView)

        // Configurações do WebView
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.allowFileAccessFromFileURLs = true
        webSettings.allowUniversalAccessFromFileURLs = true
        webView.settings.allowFileAccess = true

        // Carregar o arquivo HTML local
        webView.loadUrl("file:///android_asset/index.html")
    }
}
