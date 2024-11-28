package com.example.appdinossauro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SelectDinoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escolhadino);
        ImageButton btnCamera = findViewById(R.id.btn_camera);
        ImageButton btnDinossauro = findViewById(R.id.btn_dino);
        ImageButton btnInterrogacao = findViewById(R.id.btn_interroga);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectDinoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDinossauro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectDinoActivity.this, SelectDinoActivity.class);
                startActivity(intent);
            }
        });

        btnInterrogacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectDinoActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void go_TRex(View v){
        Intent intent = new Intent(SelectDinoActivity.this, TRexActivity.class);
        startActivity(intent);
    }
    public void go_Bronq(View v){
        Intent intent = new Intent(SelectDinoActivity.this, BronquioActivity.class);
        startActivity(intent);
    }
    public void go_Trise(View v){
        Intent intent = new Intent(SelectDinoActivity.this, TriseratosActivity.class);
        startActivity(intent);
    }
}