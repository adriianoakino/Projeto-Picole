package com.company.tudodebom.tudodebom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DAO.CarrinhoCompra;
import Model.CarrinhoComprasModel;

public class QuantidadePicoleActivity extends AppCompatActivity {

    private EditText quantidade;
    private EditText precoTotal;
    private Button adicionarPedido;
    static int idPicole = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantidade_picole);

        quantidade = (EditText) findViewById(R.id.etQuantidade);
        precoTotal = (EditText) findViewById(R.id.etPrecoTotal);
        adicionarPedido = (Button) findViewById(R.id.btnAdicionarPedido);

        Toast.makeText(this, "id 1: " + idPicole, Toast.LENGTH_SHORT).show();


        adicionarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuantidadePicoleActivity.this, "id 2: " + idPicole, Toast.LENGTH_SHORT).show();

                addPedido(idPicole);
                startActivity(new Intent(QuantidadePicoleActivity.this, ClientePedidoActivity.class));
            }
        });
    }

    public void addPedido(int id){
        Toast.makeText(QuantidadePicoleActivity.this, "id 3: " + idPicole, Toast.LENGTH_SHORT).show();
        CarrinhoComprasModel model = new CarrinhoComprasModel();

        if(id == 0){
            if(quantidade.getText().equals(0)|| quantidade.getText().equals(null)) {
                Toast.makeText(this, "Digite a quantidade ou clique me cancelar", Toast.LENGTH_SHORT);
            }else{
                model.setPrecoAbacaxiHawai(1.50 * Double.parseDouble(quantidade.getText().toString()));
                model.setQuantidadeAbacaxiHawai(Integer.parseInt(quantidade.getText().toString()));
            }
        }if(id == 1){
            if(quantidade.getText().equals(0)|| quantidade.getText().equals(null)) {
                Toast.makeText(this, "Digite a quantidade ou clique me cancelar", Toast.LENGTH_SHORT);
            }else{
                model.setPrecoAbacaxiVinho(1.50 * Double.parseDouble(quantidade.getText().toString()));
                model.setQuantidadeAbacaxiVinho(Integer.parseInt(quantidade.getText().toString()));
            }

        }if(id == 2){

            if(quantidade.getText().equals(0)|| quantidade.getText().equals(null)) {
                Toast.makeText(this, "Digite a quantidade ou clique me cancelar", Toast.LENGTH_SHORT);
            }else{
                model.setPrecoAmendoim(1.50 * Double.parseDouble(quantidade.getText().toString()));
                model.setQuantidadeAmendoim(Integer.parseInt(quantidade.getText().toString()));
            }

        }if(id == 3){

        }if(id == 4){

        }if(id == 5){

        }if(id == 6){

        }if(id == 7){

        }if(id == 8){

        }if(id == 9){

        }if(id == 10){

        }if(id == 11){

        }if(id == 12){

        }if(id == 13){

        }if(id == 14){

        }if(id == 15){

        }if(id == 16) {

        }
    }

}
