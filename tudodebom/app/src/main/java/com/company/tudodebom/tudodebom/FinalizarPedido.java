package com.company.tudodebom.tudodebom;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import DAO.FirebaseConfiguration;
import Model.CarrinhoComprasModel;
import Model.PedidoModelTest;
import Model.Pedidos;

import static Model.Pedidos.emailPedido;
import static Model.Pedidos.listaPedidos;
import static Model.Pedidos.status;
import static Model.Pedidos.totalPedido;
import static Model.Pedidos.uid;

public class FinalizarPedido extends AppCompatActivity {
    private FinalizarPedido.CustomAdptadorPedidosCliente adptador;
    private EditText troco;
    private EditText totalcompra;
    private Spinner spinner;
    private ListView listaFinalizarPedido;
    private Button btnfinalizaCompra;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_pedido);

        progressDialog = new ProgressDialog(this);

        listaFinalizarPedido = (ListView) findViewById(R.id.listaFinalizarPedido);
        adptador = new FinalizarPedido.CustomAdptadorPedidosCliente();
        listaFinalizarPedido.setAdapter(adptador);
        troco = (EditText) findViewById(R.id.etFCTroco);
        totalcompra = (EditText) findViewById(R.id.totalFCompra);
        spinner = (Spinner) findViewById(R.id.spinner);
        btnfinalizaCompra = (Button) findViewById(R.id.btnFCConfirma);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.metodopagamento_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    troco.setEnabled(true);
                } else {
                    troco.setEnabled(false);
                    troco.setText("0.00");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnfinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Registrando o pedido aguarde...");
                progressDialog.show();
                Pedidos pedidos = new Pedidos();
                //pedidos.registrarPedido(totalcompra.getText().toString(), spinner.getSelectedItem().toString(), troco.getText().toString());
                criaPedido();
                pedidos.clearList();

               // pedidos.pedidosRealizados();
                startActivity(new Intent(FinalizarPedido.this, menu_opcoes_cliente.class));
            }
        });


    }

    public void criaPedido(){
        String date = getDateTime();

        PedidoModelTest pedidoModelTest = new PedidoModelTest(listaPedidos, totalPedido, status, emailPedido, uid, date);
        DatabaseReference notasReferencia = FirebaseConfiguration.getFireBase();
        DatabaseReference novoRegistro = notasReferencia.child("pedidos").push();

        novoRegistro.setValue(pedidoModelTest);


    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }



    class CustomAdptadorPedidosCliente extends BaseAdapter {

        CarrinhoComprasModel model = new CarrinhoComprasModel();

        @Override
        public int getCount() {
            return listaPedidos.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View view = getLayoutInflater().inflate(R.layout.listview_cliente_pedido, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imagemViewPedido);
            TextView textNome = (TextView) view.findViewById(R.id.textNamePedido);
            TextView textPreco = (TextView) view.findViewById(R.id.textPrecoPedido);
            TextView textQuantidade = (TextView) view.findViewById(R.id.textQuantidadePedido);
            TextView textTotal = (TextView) findViewById(R.id.totalFCompra);

            imageView.setImageResource(model.getImages()[listaPedidos.get(position).getId()]);
            textNome.setText(model.getNomes()[listaPedidos.get(position).getId()]);
            textPreco.setText("R$: " + String.valueOf(listaPedidos.get(position).getPreco()));
            textQuantidade.setText("Quantidade:" + String.valueOf(listaPedidos.get(position).getQuantidade()));
            textTotal.setText(String.valueOf(totalPedido));

            return view;
        }


    }


}
