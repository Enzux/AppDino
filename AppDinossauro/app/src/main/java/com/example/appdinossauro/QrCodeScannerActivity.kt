package com.example.appdinossauro

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator

class QrCodeScannerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT // Trava em portrait
        initiateQrCodeScanner()
    }

    private fun initiateQrCodeScanner() {
        val intentIntegrator = IntentIntegrator(this)
        intentIntegrator.setOrientationLocked(true) // Travado em portrait
        intentIntegrator.setPrompt("Scan a QR Code")
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        intentIntegrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (intentResult != null && intentResult.contents != null) {
            // Devolver o resultado para a MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra("qr_code_result", intentResult.contents)
            setResult(RESULT_OK, resultIntent)
            finish() // Fecha o scanner e volta para MainActivity
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}