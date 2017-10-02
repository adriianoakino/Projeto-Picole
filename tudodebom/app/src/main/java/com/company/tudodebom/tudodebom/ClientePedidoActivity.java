package com.company.tudodebom.tudodebom;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import Model.CarrinhoComprasModel;

public class ClientePedidoActivity extends AppCompatActivity {


    private ListView list;
    private Button btn_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_pedido);

        btn_add = (Button) findViewById(R.id.btn_add);
        list = (ListView) findViewById(R.id.list);
       // ClientePedidoActivity.CustomAdapitador customAdaptador = new ClientePedidoActivity.CustomAdapitador();
        //list.setAdapter(customAdaptador);











        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClientePedidoActivity.this, PicoleActivity.class));
            }
        });

    }

  /*  private void maybeRemoveItem(final int pos) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm);
        String fmt = getResources().getString(R.string.confirm_message);
        builder.setMessage(String.format(fmt,itemList.get(pos).getText()));
        builder.setPositiveButton(R.string.remove, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                itemList.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.create().show();
    }*/



   class CustomAdapitador extends BaseAdapter {

       CarrinhoComprasModel model;
        @Override
        public int getCount() {
            Toast.makeText(ClientePedidoActivity.this, "Cont" +model.getListaCompra().size() , Toast.LENGTH_SHORT).show();
            return model.getListaCompra().size();
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

            return view;
        }


    }





}
