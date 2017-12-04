package com.company.tudodebom.tudodebom;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Helper.AttributesLista;
import Model.CarrinhoComprasModel;
import Model.PedidoModelTest;
import Model.Pedidos;

import static Model.Pedidos.listaPedidos;
import static Model.Pedidos.totalPedido;
import static android.widget.AbsListView.MultiChoiceModeListener;

public class ClientePedidoActivity extends AppCompatActivity {

    ClientePedidoActivity.CustomAdptadorPedidosCliente adptador;
    private ListView listaClientePedidos;
    private List<AttributesLista> listaids = new ArrayList<AttributesLista>();
    private Button btn_add;
    private Button btn_confirm_pedido;
    private Toolbar toolbar;
    private ImageButton imgTopo;
    private TextView precoTotal;
    private int checkedCount = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_pedido);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_confirm_pedido = (Button) findViewById(R.id.btn_confirm_pedido);
        precoTotal = (TextView) findViewById(R.id.displayTotalCompra);
        imgTopo = (ImageButton) findViewById(R.id.backmenu);

        listaClientePedidos = (ListView) findViewById(R.id.listaClientePedido);

        adptador = new ClientePedidoActivity.CustomAdptadorPedidosCliente();
        listaClientePedidos.setAdapter(adptador);
        listaClientePedidos.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClientePedidoActivity.this, PicoleActivity.class));
            }
        });

        imgTopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listaPedidos.size() > 0){
                    openDialog();
                }else {
                    startActivity(new Intent(ClientePedidoActivity.this, menu_opcoes_cliente.class));
                }
            }
        });

        btn_confirm_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClientePedidoActivity.this, FinalizarPedido.class));
            }
        });

        if(listaPedidos.size() > 0 ){ btn_confirm_pedido.setVisibility(View.VISIBLE); }

         listaClientePedidos.setMultiChoiceModeListener(new MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                checkedCount = listaClientePedidos.getCheckedItemCount();
                mode.setTitle(checkedCount + " Selecionados");
                listaids.add(listaPedidos.get(position));
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.delete_itens, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch(item.getItemId()){
                    case R.id.delete:
                        for(AttributesLista l : listaids) {
                            Toast.makeText(ClientePedidoActivity.this, "id: " +l.getPreco(), Toast.LENGTH_SHORT).show();
                           if(listaPedidos.size() > 1) {
                                totalPedido = totalPedido - l.getPreco();
                            }else{
                                totalPedido = 0;
                                precoTotal.setText("Total a pagar R$: 0.00");
                                btn_confirm_pedido.setVisibility(View.INVISIBLE);
                            }
                            listaPedidos.remove(l);
                            listaids.remove(l);
                            checkedCount = 0;
                            adptador.notifyDataSetChanged();
                            mode.finish();
                        }
                }

                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) { }
        });

    }

    @Override
    public void onBackPressed() {
       // if(listaPedidos.size() > 0){ openDialog(); }
        //else { startActivity(new Intent(ClientePedidoActivity.this, menu_opcoes_cliente.class)); }
    }

    public void openDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(ClientePedidoActivity.this);
        dialog.setTitle(R.string.dialog_text).setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
               // listaPedidos = new ArrayList<AttributesLista>();
                listaids = new ArrayList<AttributesLista>();
                //totalPedido = 0;
                startActivity(new Intent(ClientePedidoActivity.this, menu_opcoes_cliente.class));
            }
        }).setNegativeButton(R.string.Cancelar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { dialog.dismiss(); }
        });
        dialog.create();
        dialog.show();
    }


    class CustomAdptadorPedidosCliente extends BaseAdapter {

       CarrinhoComprasModel model = new CarrinhoComprasModel();

        @Override
        public int getCount() { return listaPedidos.size(); }

        @Override
        public Object getItem(int position) { return position; }

        @Override
        public long getItemId(int position) { return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View view = getLayoutInflater().inflate(R.layout.listview_cliente_pedido, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imagemViewPedido);
            TextView textNome = (TextView) view.findViewById(R.id.textNamePedido);
            TextView textPreco = (TextView) view.findViewById(R.id.textPrecoPedido);
            TextView textQuantidade = (TextView) view.findViewById(R.id.textQuantidadePedido);
            TextView textTotal = (TextView) findViewById(R.id.displayTotalCompra);

            imageView.setImageResource(model.getImages()[listaPedidos.get(position).getId()]);
            textNome.setText(model.getNomes()[listaPedidos.get(position).getId()]);






            textPreco.setText("R$: "+ String.valueOf(listaPedidos.get(position).getPreco()));
            textQuantidade.setText("Quantidade:" + String.valueOf(listaPedidos.get(position).getQuantidade()));
            textTotal.setText("Total a pagar R$: " + String.valueOf(totalPedido));

            return view;
        }


    }


}
