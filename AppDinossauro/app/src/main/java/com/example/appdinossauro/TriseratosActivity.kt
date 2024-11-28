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

        var nomeCientifico: TextView = findViewById(R.id.nomeCientifico)
        nomeCientifico.text = "Triceratops horridus"

        var nomePopular: TextView = findViewById(R.id.nomePopular)
        nomePopular.text = "Tricerátopo"

        var periodo: TextView = findViewById(R.id.periodo)
        periodo.text = "Período: Cretáceo Superior (~68-66 milhões de anos atrás) "

        var dieta: TextView = findViewById(R.id.dieta)
        dieta.text = "Dieta: Herbívora"

        var tamanho: TextView = findViewById(R.id.tamanho)
        tamanho.text = "Tamanho: Cerca de 9 metros de comprimento e 3 metros de altura "

        var peso: TextView = findViewById(R.id.peso)
        peso.text = "Peso: Aproximadamente 6-12 toneladas "

        var txt: TextView = findViewById(R.id.txt)
        txt.text = "O Tricerátopo possuía uma das maiores cabeças de qualquer dinossauro terrestre, com três chifres característicos e um grande escudo ósseo que o protegia de predadores como o Tiranossauro Rex. Seus chifres eram provavelmente usados tanto para defesa quanto para demonstração de força em combates territoriais ou rituais de acasalamento."


        localServer = LocalServer(this)
        localServer.start()

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.loadUrl("http://localhost:8080/PgnDino/Triseratops.html")
    }

    override fun onDestroy() {
        super.onDestroy()
        localServer.stop()
    }
}