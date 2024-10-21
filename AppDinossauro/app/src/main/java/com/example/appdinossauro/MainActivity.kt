package com.example.appdinossauro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val QR_CODE_REQUEST_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scanBtn = findViewById<Button>(R.id.scanner)

        scanBtn.setOnClickListener {
            val intent = Intent(this, QrCodeScannerActivity::class.java)
            startActivityForResult(intent, QR_CODE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == QR_CODE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            val qrCodeResult = data.getStringExtra("qr_code_result")
            val textView = findViewById<TextView>(R.id.text)
            textView.text = qrCodeResult
        }
    }
}