package com.company.tudodebom.tudodebom;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import Helper.AttributesLista;
import Helper.Base64Custom;
import Model.PedidoModelTest;
import Model.Usuarios;

import static Model.Pedidos.criptoId;
import static Model.Pedidos.emailPedido;
import static Model.Pedidos.passwordPedido;
import static Model.Pedidos.uid;
import static Model.Pedidos.usuarioAtual;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mPasswordField;

    private Button mLoginBtn;
    private Button mRegisterButton;
    private Button mRecoveryPassword;

    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        mEmailField = (EditText) findViewById(R.id.emailField);
        mPasswordField = (EditText) findViewById(R.id.passwordField);

        mLoginBtn = (Button) findViewById(R.id.btnLogar);
        mRegisterButton = (Button) findViewById(R.id.btnRegistrar);
        mRecoveryPassword = (Button) findViewById(R.id.btnRecoveryPassword);

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
        mRecoveryPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoveryPassword();
            }
        });
    }

    private void startSingIn() {

        final Usuarios user = new Usuarios();
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
                        PedidoModelTest ped = new PedidoModelTest();
                        emailPedido = user.getEmail();
                        passwordPedido = user.getPassword();
                        FirebaseUser currentUser = mAuth.getCurrentUser();
                        usuarioAtual = currentUser;
                        uid = currentUser.getUid();
                        String identificadorUsuario = Base64Custom.codificarBase64(user.getEmail());
                        criptoId = identificadorUsuario;

                       // ped.setEmail(user.getEmail());
                        //ped.setUid(currentUser.getUid());
                        startActivity(new Intent(LoginActivity.this, menu_opcoes_cliente.class));
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

    @Override
    public void onBackPressed() {
    }


    public void recoveryPassword() {
        if(mEmailField.getText().toString().equals("") || mEmailField.getText().toString().equals(null) || TextUtils.isEmpty(mEmailField.getText().toString())){
            Toast.makeText(LoginActivity.this, "Digite o Email que deseja recuperar a senha", Toast.LENGTH_LONG);
        }else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
            dialog.setTitle(R.string.dialog_text_login).setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    mAuth.sendPasswordResetEmail(mEmailField.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){Toast.makeText(LoginActivity.this, "Enviado para seu e-mail", Toast.LENGTH_LONG);}
                            else{
                                Toast.makeText(LoginActivity.this, "Email digitado é invalido", Toast.LENGTH_LONG);
                            }
                        }
                    });
                }
            }).setNegativeButton(R.string.Cancelar, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) { dialog.dismiss(); }
            });
            dialog.create();
            dialog.show();
        }
    }


}














