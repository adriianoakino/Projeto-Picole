package com.company.tudodebom.tudodebom;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import DAO.FirebaseConfiguration;
import Helper.Base64Custom;
import Helper.Preferencias;
import Model.Usuarios;

public class RegisterAccount extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
    private Button buttonCancelar;
    private EditText editTextFullName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextStreet;
    private EditText editTextHouseNumber;
    private EditText editTextHouseCEP;
    private EditText editTextHouseBairro;
    private EditText editTextHouseCity;
    private EditText editTextHouseState;
    private EditText editTextTelefone;
    private EditText editTextCelular;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);

        progressDialog = new ProgressDialog(this);

        buttonRegister = (Button) findViewById(R.id.ButtonRegistrarAccount);
        buttonCancelar = (Button) findViewById(R.id.buttonCancelRegister);

        editTextFullName    = (EditText) findViewById(R.id.FullName);
        editTextEmail       = (EditText) findViewById(R.id.email);
        editTextPassword    = (EditText) findViewById(R.id.password);
        editTextStreet      = (EditText) findViewById(R.id.street);
        editTextHouseNumber = (EditText) findViewById(R.id.hauseNumber);
        editTextHouseCEP    = (EditText) findViewById(R.id.houseCEP);
        editTextHouseBairro = (EditText) findViewById(R.id.houseBairro);
        editTextHouseCity   = (EditText) findViewById(R.id.houseCity);
        editTextHouseState  = (EditText) findViewById(R.id.houseState);
        editTextTelefone    = (EditText) findViewById(R.id.telephone);
        editTextCelular     = (EditText) findViewById(R.id.cellphone);

        buttonRegister.setOnClickListener(this);
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelRegister();

            }
        });

    }



    private void registerUser() {
        final Usuarios user = new Usuarios();
        user.setNome(editTextFullName.getText().toString());
        user.setEmail(editTextEmail.getText().toString().trim());
        user.setPassword(editTextPassword.getText().toString().trim());
        user.setRua(editTextStreet.getText().toString());
        user.setNumero(editTextHouseNumber.getText().toString());
        user.setCEP(editTextHouseCEP.getText().toString());
        user.setBairro(editTextHouseBairro.getText().toString());
        user.setCidade(editTextHouseCity.getText().toString());
        user.setEstado(editTextHouseState.getText().toString());
        user.setTelefone(editTextTelefone.getText().toString());
        user.setCelular(editTextCelular.getText().toString());

        if(TextUtils.isEmpty(user.getNome())){
            Toast.makeText(this,"Por favor digite seu nome Completo",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(user.getEmail())){
            Toast.makeText(this,"Por favor digite seu E-mail",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(user.getPassword())){
            Toast.makeText(this,"Por favor digite seu Password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(user.getRua())){
            Toast.makeText(this,"Por favor digite o nome da sua Rua",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(user.getNumero())){
            Toast.makeText(this,"Por favor digite o nome do seu Número",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(user.getCEP())){
            Toast.makeText(this,"Por favor digite o seu CEP",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(user.getBairro())){
            Toast.makeText(this,"Por favor digite o nome do seu Bairro",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(user.getCidade())){
            Toast.makeText(this,"Por favor digite o nome da sua Cidade",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(user.getCidade())){
            Toast.makeText(this,"Por favor digite o nome do seu Estado",Toast.LENGTH_SHORT).show();
            return;
        }


        //firebaseAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword());
        firebaseAuth = FirebaseConfiguration.getFirebaseAuth();
        firebaseAuth.createUserWithEmailAndPassword(
                user.getEmail(),
                user.getPassword()
        ).addOnCompleteListener(RegisterAccount.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.setMessage("Registrando Aguarde");
                    progressDialog.show();
                    Toast.makeText(RegisterAccount.this, "Usuario Cadastrado Com Sucesso!", Toast.LENGTH_LONG).show();

                    String identificadorUsuario = Base64Custom.codificarBase64(user.getEmail());

                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    user.setId(identificadorUsuario);
                    user.salvarUsuario();


                    Preferencias preferencias = new Preferencias(RegisterAccount.this);
                    preferencias.salvarUsuarioPreferencias(identificadorUsuario, user.getNome());

                    abrirLoginUser();
                }else{
                    String erroException = "";

                    try {
                        throw task.getException();
                    } catch(FirebaseAuthWeakPasswordException e){
                        erroException = "Digite uma senha mais forte, contendo minimo 8 caracterers";
                    } catch(FirebaseAuthInvalidCredentialsException e) {
                        erroException = "O e-mail digitado é invalido, digite um novo e-mail";
                    } catch (FirebaseAuthUserCollisionException e){
                        erroException = "Esse e-mail ja foi cadastrado, utilize outro !";
                    } catch (Exception e){
                        erroException = "Erro ao efetuar cadastro";
                        e.printStackTrace();
                    }
                    Toast.makeText(RegisterAccount.this, "Erro: " + erroException, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void abrirLoginUser(){
        Intent intent = new Intent(RegisterAccount.this, LoginActivity.class);
        startActivity(intent);
        finish();



    }

    public void cancelRegister(){
        Usuarios user = new Usuarios();
        user.setNome(editTextFullName.getText().toString());
        user.setEmail(editTextEmail.getText().toString().trim());
        user.setPassword(editTextPassword.getText().toString().trim());
        user.setRua(editTextStreet.getText().toString());
        user.setNumero(editTextHouseNumber.getText().toString());
        user.setCEP(editTextHouseCEP.getText().toString());
        user.setBairro(editTextHouseBairro.getText().toString());
        user.setCidade(editTextHouseCity.getText().toString());
        user.setEstado(editTextHouseState.getText().toString());
        user.setTelefone(editTextTelefone.getText().toString());
        user.setCelular(editTextCelular.getText().toString());
        Intent intent = new Intent(RegisterAccount.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {
            registerUser();
        }
    }
}
