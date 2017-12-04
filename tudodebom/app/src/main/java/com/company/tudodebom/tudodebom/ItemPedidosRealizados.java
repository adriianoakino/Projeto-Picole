package com.company.tudodebom.tudodebom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import Adapter.ItemPedidosRealizadosAdapter;
import Adapter.PedidosRealizadosAdapter;
import Model.PedidoModelTest;

public class ItemPedidosRealizados extends AppCompatActivity {
     static ItemPedidosRealizadosAdapter adapterItemPedidoRealizado;
    private ListView mListViewItemPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_pedidos_realizados);

        mListViewItemPedido = (ListView) findViewById(R.id.list_item_pedidoRealizado_sorvete);
        //adapterItemPedidoRealizado = new ItemPedidosRealizadosAdapter(getApplicationContext(), ,position);
        mListViewItemPedido.setAdapter(adapterItemPedidoRealizado);


    }

    @Override
    public void onBackPressed() {
        adapterItemPedidoRealizado = null;
        startActivity(new Intent(ItemPedidosRealizados.this, PedidosRealizados.class));
    }

}
