package com.example.appdinossauro


import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TRexActivity : AppCompatActivity() {

    private lateinit var localServer: LocalServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dinolayout)

        localServer = LocalServer(this)
        localServer.start()

        var txt1: TextView = findViewById(R.id.txt)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.loadUrl("http://localhost:8080/PgnDino/TRex.html")
        txt1.text = "O TRex é foda"
    }

    override fun onDestroy() {
        super.onDestroy()
        localServer.stop()
    }
}