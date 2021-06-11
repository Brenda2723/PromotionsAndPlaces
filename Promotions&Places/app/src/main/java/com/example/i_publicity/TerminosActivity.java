package com.example.i_publicity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.util.Log;
import android.view.View;

public class TerminosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos);
    }

    public void activity_regresar(View view) {
        Intent principal = new Intent(this, LoginRegistrarActivity.class);
        startActivity(principal);
    }
}