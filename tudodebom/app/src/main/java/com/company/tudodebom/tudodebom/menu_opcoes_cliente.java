package com.company.tudodebom.tudodebom;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import Model.Pedidos;

import static com.company.tudodebom.tudodebom.R.id.btnSair;
import static com.company.tudodebom.tudodebom.R.id.drower;
import static com.company.tudodebom.tudodebom.R.id.openMenuLateral;
import static com.company.tudodebom.tudodebom.R.id.tabMode;

public class menu_opcoes_cliente extends AppCompatActivity
        {

    private ImageButton pedidosrealizados;
    private ImageButton novopedido;
    private ImageButton btnTopo;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcoes_cliente);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pedidosrealizados = (ImageButton) findViewById(R.id.pedidosrealizados);
        novopedido = (ImageButton) findViewById(R.id.novopedido);

        navigationView = (NavigationView) findViewById(R.id.openMenuLateral);

        btnTopo = (ImageButton) findViewById(R.id.opcoesTopo);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drower);

        btnTopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });

        novopedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu_opcoes_cliente.this, ClientePedidoActivity.class));
            }
        });

        pedidosrealizados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu_opcoes_cliente.this, PedidosRealizados.class));
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Toast.makeText(menu_opcoes_cliente.this,"id: "+ id, Toast.LENGTH_LONG);
                if (id == R.id.nav_novo_pedido) { Toast.makeText(menu_opcoes_cliente.this,"jjjj", Toast.LENGTH_LONG); startActivity(new Intent(menu_opcoes_cliente.this, ClientePedidoActivity.class)); }
                else if (id == R.id.nav_pedidos_realizados) {startActivity(new Intent(menu_opcoes_cliente.this, PedidosRealizados.class));}
                else if (id == R.id.nav_logout) {
                    Pedidos.emailPedido = "";
                    Pedidos.criptoId = "";
                    Pedidos.listaPedidos = null;
                    Pedidos.usuarioAtual = null;
                    startActivity(new Intent(menu_opcoes_cliente.this, LoginActivity.class));}

                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
    }



}
