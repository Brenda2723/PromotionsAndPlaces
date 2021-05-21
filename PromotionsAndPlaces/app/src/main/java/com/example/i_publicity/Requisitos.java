package com.example.i_publicity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Requisitos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisitos);
    }
    public void Entendido(View view){
        Intent entendido = new Intent(this, LoginActivity.class);
        startActivity(entendido);
        finish();
    }
}