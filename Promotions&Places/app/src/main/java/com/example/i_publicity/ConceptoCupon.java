package com.example.i_publicity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ConceptoCupon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concepto_cupon);
    }
    public void PerfilFragment(View view) {
        Intent iniciar = new Intent(this, PerfilFragment.class);
        startActivity(iniciar);
    }

}