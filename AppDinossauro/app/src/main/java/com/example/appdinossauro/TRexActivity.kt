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

        var nomeCientifico: TextView = findViewById(R.id.nomeCientifico)
        nomeCientifico.text = "Tyrannosaurus rex"

        var nomePopular: TextView = findViewById(R.id.nomePopular)
        nomePopular.text = "Tiranossauro-rex"

        var periodo: TextView = findViewById(R.id.periodo)
        periodo.text = "Periodo: Cretáceo Superior (~68-66 milhões de anos atrás)"

        var dieta: TextView = findViewById(R.id.dieta)
        dieta.text = "Dieta: Carnívora"

        var tamanho: TextView = findViewById(R.id.tamanho)
        tamanho.text = "Tamanho: 12 metros de comprimento e 3,65 metros de altura"

        var peso: TextView = findViewById(R.id.peso)
        peso.text = "Peso: Entre 5,5 e oito toneladas"

        var txt: TextView = findViewById(R.id.txt)
        txt.text = "O Tiranossauro Rex é, sem dúvida, o dinossauro carnívoro mais famoso. Ele possuía mandíbulas extremamente poderosas, capazes de esmagar ossos, e dentes serrilhados com cerca de 18 cm. Suas patas dianteiras eram curtas, com apenas dois dedos, mas suas patas traseiras eram robustas, conferindo-lhe grande força e velocidade em curtas distâncias."


        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.loadUrl("http://localhost:8080/PgnDino/TRex.html")
    }

    override fun onDestroy() {
        super.onDestroy()
        localServer.stop()
    }
}