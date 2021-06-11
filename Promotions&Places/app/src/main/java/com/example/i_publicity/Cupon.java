package com.example.i_publicity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cupon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupon);
    }

    public void ConceptoCupon(View view) {
        Intent iniciar = new Intent(this, ConceptoCupon.class);
        startActivity(iniciar);
    }
    public void NotificationlFragment(View view) {
        Intent iniciar = new Intent(this, NotificationlFragment.class);
        startActivity(iniciar);
    }
}