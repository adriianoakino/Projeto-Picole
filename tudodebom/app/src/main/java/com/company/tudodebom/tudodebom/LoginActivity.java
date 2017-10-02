package com.company.tudodebom.tudodebom;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Model.Usuarios;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;

    private Button mLoginBtn;
    private Button mRegisterButton;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        mEmailField = (EditText) findViewById(R.id.emailField);
        mPasswordField = (EditText) findViewById(R.id.passwordField);

        mLoginBtn = (Button) findViewById(R.id.btnLogar);
        mRegisterButton = (Button) findViewById(R.id.btnRegistrar);

      /*  mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(LoginActivity.this, MainPicoleActivity.class));

                }
            }
        };*/

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSingIn();
            }
        });
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreRegistroUsuario();
            }
        });
    }



  /*  @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }*/


    private void startSingIn() {

        Usuarios user = new Usuarios();
        user.setEmail(mEmailField.getText().toString());
        user.setPassword(mPasswordField.getText().toString());

        if(TextUtils.isEmpty(user.getEmail()) || TextUtils.isEmpty(user.getPassword())) {
            Toast.makeText(LoginActivity.this, "Preencha o Email e Senha", Toast.LENGTH_LONG).show();

        } else {
            mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Email ou senha errado", Toast.LENGTH_LONG).show();
                    }else{
                        startActivity(new Intent(LoginActivity.this, ClientePedidoActivity.class));
                    }
                }
            });
        }


    }

    public void abreRegistroUsuario(){
        Intent intent = new Intent(LoginActivity.this, RegisterAccount.class);
        startActivity(intent);
        finish();
    }


}














