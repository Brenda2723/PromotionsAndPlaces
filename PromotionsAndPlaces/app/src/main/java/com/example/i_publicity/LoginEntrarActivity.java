package com.example.i_publicity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginEntrarActivity extends AppCompatActivity {

    EditText editTextUsuario;
    EditText editTextContrasena;
    Button btn_entrar_cuenta;
    String usuario = "";
    String contrasena = "";


    private FirebaseAuth mAuth;


   // private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_entrar);
        mAuth = FirebaseAuth.getInstance();

       // mDatabase = FirebaseDatabase.getInstance().getReference();

        editTextUsuario = findViewById(R.id.user);
        editTextContrasena = findViewById(R.id.password_toggle);
        btn_entrar_cuenta = findViewById(R.id.btn_entrar_cuenta);

        btn_entrar_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = editTextUsuario.getText().toString();
                contrasena = editTextContrasena.getText().toString();

                if (!usuario.isEmpty() && !contrasena.isEmpty()) {
                    loginUser();
                } else {
                    Toast.makeText(LoginEntrarActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void loginUser() {
        mAuth.signInWithEmailAndPassword(usuario, contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(LoginEntrarActivity.this, Agradecimientos.class));
                    finish();
                } else {
                    Toast.makeText(LoginEntrarActivity.this, "Sesión incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

      }
