package com.example.appdinossauro


import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class TRexActivity : AppCompatActivity() {

    private lateinit var localServer: LocalServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dinolayout)

        localServer = LocalServer(this)
        localServer.start()

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.loadUrl("http://localhost:8080")
    }

    override fun onDestroy() {
        super.onDestroy()
        localServer.stop()
    }
}