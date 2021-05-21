package com.example.i_publicity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AceptarRechazar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptar_rechazar);
    }

    public void Permitir(View view){
        Intent permitir = new Intent(this, Requisitos.class);
        startActivity(permitir);
        finish();
    }

    public void Rechazar(View view){
        Intent rechazar = new Intent(this, MainActivity.class);
        startActivity(rechazar);
        finish();
    }
}