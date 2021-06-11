package com.example.i_publicity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DatosGuardados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_guardados);
    }

    public void Regresar_Home(View view) {
        Intent iniciar = new Intent(this, Agradecimientos.class);
        startActivity(iniciar);
    }
}