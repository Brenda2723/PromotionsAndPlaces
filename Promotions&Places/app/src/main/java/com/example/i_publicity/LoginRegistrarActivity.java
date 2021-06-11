package com.example.i_publicity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class LoginRegistrarActivity extends AppCompatActivity {

    Button btn_aceptarcuenta;
    EditText editTextNombre;
    EditText editTextApellido;
    EditText editTextUsuario;
    EditText editTextContraseña;
    EditText editTextFechaNacimiento;
    EditText editTextCodigoPostal;
    TextView terminos;

    String name = "";
    String apellido = "";
    String usuario = "";
    String contraseña= "";
    String nacimiento = "";
    String cp = "";

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registrar);
        btn_aceptarcuenta=findViewById(R.id.btn_aceptarcuenta);
        terminos=findViewById(R.id.terminos);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        editTextNombre = findViewById(R.id.nombre);
        editTextApellido = findViewById(R.id.apellido);
        editTextUsuario = findViewById(R.id.nomusuario);
        editTextContraseña = findViewById(R.id.crearpass);
        editTextFechaNacimiento = findViewById(R.id.fecha_nac);
        editTextCodigoPostal = findViewById(R.id.cod_postal);
        btn_aceptarcuenta = findViewById(R.id.btn_aceptarcuenta);

        btn_aceptarcuenta.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(LoginRegistrarActivity.this, "Información guardada con éxito", Toast.LENGTH_SHORT).show();
                name = editTextNombre.getText().toString();
                apellido = editTextApellido.getText().toString();
                usuario = editTextUsuario.getText().toString();
                contraseña = editTextContraseña.getText().toString();
                nacimiento = editTextFechaNacimiento.getText().toString();
                cp = editTextCodigoPostal.getText().toString();

                if(!name.isEmpty() && !apellido.isEmpty() && !usuario.isEmpty() &&
                        !contraseña.isEmpty() && !nacimiento.isEmpty() && !cp.isEmpty()){
                    if (contraseña.length()>=8){
                        registerUser();
                    }else{
                        Toast.makeText(LoginRegistrarActivity.this, "Contraseña mínimo de 8 carácteres", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(LoginRegistrarActivity.this, "Completar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        terminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginRegistrarActivity.this, TerminosActivity.class));
            }
        });
    }
/*
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(LoginRegistrarActivity.this, Agradecimientos.class));
            finish();
        }/*

        //updateUI(currentUser);
    }
/*
    public void registerUser(View view){

            mAuth.createUserWithEmailAndPassword(editTextUsuario.getText().toString(), editTextContraseña.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getApplicationContext(), "Usuario Creado.", Toast.LENGTH_SHORT).show();

                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(), Agradecimientos.class);
                                startActivity(i);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                                //  updateUI(null);
                            }
                            // ...
                        }
                    });

    }*/


    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(usuario, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("apellido", apellido);
                    map.put("usuario", usuario);
                    map.put("contraseña", contraseña);
                    map.put("nacimiento", nacimiento);
                    map.put("cp", cp);

                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                startActivity(new Intent(LoginRegistrarActivity.this, Agradecimientos.class));
                                finish();
                            }else {
                                Toast.makeText(LoginRegistrarActivity.this, "No se pudieron crear los datos coorectamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(LoginRegistrarActivity.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void activity_regresar(View view) {
        Intent principal = new Intent(this, LoginActivity.class);
        startActivity(principal);
    }

}