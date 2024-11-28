package com.example.appdinossauro


import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TriseratosActivity : AppCompatActivity() {

    private lateinit var localServer: LocalServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dinolayout)

        var txt1: TextView = findViewById(R.id.txt)

        localServer = LocalServer(this)
        localServer.start()

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.loadUrl("http://localhost:8080/PgnDino/Triseratops.html")
        txt1.text = "O Triseratops é foda"
    }

    override fun onDestroy() {
        super.onDestroy()
        localServer.stop()
    }
}