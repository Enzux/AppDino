package com.example.appdinossauro


import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BronquioActivity : AppCompatActivity() {

    private lateinit var localServer: LocalServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dinolayout)

        localServer = LocalServer(this)
        localServer.start()

        var nomeCientifico: TextView = findViewById(R.id.nomeCientifico)
        nomeCientifico.text = "Brachiosaurus altithorax"

        var nomePopular: TextView = findViewById(R.id.nomePopular)
        nomePopular.text = "Braquiossauro"

        var periodo: TextView = findViewById(R.id.periodo)
        periodo.text = "Período: Jurássico Superior (~154-153 milhões de anos atrás)"

        var dieta: TextView = findViewById(R.id.dieta)
        dieta.text = "Dieta: Herbívora"

        var tamanho: TextView = findViewById(R.id.tamanho)
        tamanho.text = "Tamanho: Aproximadamente 25 metros de comprimento e 12 metros de altura"

        var peso: TextView = findViewById(R.id.peso)
        peso.text = "Peso: Cerca de 50 toneladas"

        var txt: TextView = findViewById(R.id.txt)
        txt.text = "O Braquiossauro se destacava entre os outros dinossauros de pescoço longo por suas patas dianteiras serem mais longas do que as traseiras, o que lhe dava uma postura erguida única. Seu longo pescoço permitia que ele alcançasse o topo das árvores para se alimentar de folhas, o que o colocava acima de muitos outros herbívoros em termos de acesso à comida."


        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.loadUrl("http://localhost:8080/PgnDino/Braqui.html")
    }

    override fun onDestroy() {
        super.onDestroy()
        localServer.stop()
    }
}