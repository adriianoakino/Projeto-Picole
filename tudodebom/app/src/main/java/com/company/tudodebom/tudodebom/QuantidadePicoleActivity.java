package com.company.tudodebom.tudodebom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Helper.AttributesLista;

import static Model.Pedidos.listaPedidos;
import static Model.Pedidos.totalPedido;


public class QuantidadePicoleActivity extends AppCompatActivity {

    static int idPicole = -1;
    private EditText quantidade;
    private EditText precoTotal;
    private EditText precoUnitario;
    private Button adicionarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantidade_picole);

        quantidade = (EditText) findViewById(R.id.etQuantidade);
        precoTotal = (EditText) findViewById(R.id.etPrecoTotal);
        precoUnitario = (EditText) findViewById(R.id.etPrecoUnitario);
        adicionarPedido = (Button) findViewById(R.id.btnAdicionarPedido);

        if(idPicole == 12){
            precoUnitario.setText("2.00");
        }

        quantidade.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_PREVIOUS || actionId == EditorInfo.IME_FLAG_NAVIGATE_PREVIOUS || actionId == EditorInfo.IME_ACTION_NONE) {
                    if (quantidade.getText().toString().equals("") || quantidade.getText().toString().equals(null)) {
                        Toast.makeText(QuantidadePicoleActivity.this, "Por Favor coloque a quantidade do produto que deseja e clique em OK no teclado", Toast.LENGTH_LONG).show();
                        return false;
                    } else {
                        double valor = Double.parseDouble(quantidade.getText().toString());
                        precoTotal.setText(String.valueOf(valor * Double.parseDouble(precoUnitario.getText().toString())));
                        totalPedido += Double.parseDouble(precoTotal.getText().toString());
                        dismissKeyboard(QuantidadePicoleActivity.this);
                        return true;
                    }
                } else {
                    return false;
                }
            }
        });

        adicionarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(precoTotal.getText().toString().equals(0) || precoTotal.getText().toString().equals(null) || precoTotal.getText().toString().equals("")){
                    Toast.makeText(QuantidadePicoleActivity.this, "Por Favor coloque a quantidade do produto que deseja e clique em OK no teclado", Toast.LENGTH_LONG).show();
                }else {
                    addPedido(idPicole);
                    startActivity(new Intent(QuantidadePicoleActivity.this, ClientePedidoActivity.class));
                }
            }
        });
    }

    private void addPedido(int id){
        listaPedidos.add(new AttributesLista(id, Integer.parseInt(quantidade.getText().toString()), Double.parseDouble(precoTotal.getText().toString())));
    }

    public void dismissKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(null != activity.getCurrentFocus()){
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getApplicationWindowToken(), 0);
        }
    }


}
