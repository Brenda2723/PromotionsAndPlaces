package com.example.i_publicity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.sql.DatabaseMetaData;
import java.util.HashMap;
import java.util.Map;

public class EditarDatos extends AppCompatActivity {

    EditText editTextName;
    EditText editTextApellido;
    EditText editTextUsuario;
    EditText editTextContraseña;
    EditText getEditTextContraseña;
    EditText editTextFecha;
    EditText editTextCP;
    Button btn_datos;

    private DatabaseReference mDataBase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_datos);
        editTextName = findViewById(R.id.nombre);
        editTextApellido = findViewById(R.id.apellido);
        editTextUsuario = findViewById(R.id.nomusuario);
        editTextContraseña = findViewById(R.id.crearpass);
        editTextFecha = findViewById(R.id.fecha_nac);
        editTextCP = findViewById(R.id.cod_postal);

        btn_datos = findViewById(R.id.btn_aceptarcuenta);


    }

    public void activity_regresar(View view) {
        Intent principal = new Intent(this, PerfilFragment.class);
        startActivity(principal);
    }
/*
    public void Datos_Guardados(View view) {
        Intent iniciar = new Intent(this, DatosGuardados.class);
        startActivity(iniciar);
    }*/
}