package com.example.i_publicity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginEntrarActivity extends AppCompatActivity {

      private EditText emailEditText;
      private EditText passwordEditText;
      private Button btnSendToLogin;

      private String email = "";
      private String password = "";

      private FirebaseAuth mAuth;


      protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_entrar);

            mAuth = FirebaseAuth.getInstance();

            emailEditText = (EditText) findViewById(R.id.emailEditText);
            passwordEditText = (EditText) findViewById(R.id.passwordEditText);
            btnSendToLogin = (Button) findViewById(R.id.btnSendToLogin);

            btnSendToLogin.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                        email = emailEditText.getText().toString();
                        password = passwordEditText.getText().toString();

                        if (!email.isEmpty() && !password.isEmpty()){
                              loginUser();
                        }
                        else{
                              Toast.makeText(LoginEntrarActivity.this, "Complete los campos",Toast.LENGTH_SHORT).show();
                        }

                  }
            });
      }

      private void loginUser(){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                              startActivity(new Intent(LoginEntrarActivity.this, ProfileActivity.class));
                              finish();
                        }
                        else{
                              Toast.makeText(LoginEntrarActivity.this, "No se pudo iniciar sesion y compruebe los datos",Toast.LENGTH_SHORT).show();
                        }

                  }
            });

      }
}
