package com.example.appdinossauro;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        Button btnCamera = findViewById(R.id.btn_camera);
        Button btnDinossauro = findViewById(R.id.btn_dino);
        Button btnInterrogacao = findViewById(R.id.btn_interroga);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDinossauro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnInterrogacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}