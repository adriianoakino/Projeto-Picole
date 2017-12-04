package com.company.tudodebom.tudodebom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapter.ItemPedidosRealizadosAdapter;
import Adapter.PedidosRealizadosAdapter;
import Model.PedidoModelTest;


public class PedidosRealizados extends AppCompatActivity {

    private ListView mListPedidosRealizados;
    private DatabaseReference mDatabase;
    private FirebaseDatabase mFirebaseDatabase;

    public List<PedidoModelTest> listPedidos = new ArrayList<PedidoModelTest>();

    private PedidosRealizadosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_realizados);

        iniciaComponents();
        iniciaFirebase();
        pesquisaBanco();

        mListPedidosRealizados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PedidosRealizados.this, position, Toast.LENGTH_LONG);
                ItemPedidosRealizados.adapterItemPedidoRealizado = new ItemPedidosRealizadosAdapter(getApplicationContext(), listPedidos, position);
                startActivity(new Intent(PedidosRealizados.this, ItemPedidosRealizados.class));
            }
        });
    }

    public void iniciaComponents() {
        mListPedidosRealizados = (ListView) findViewById(R.id.listPedidosRealizados);
    }

    public void iniciaFirebase(){
        FirebaseApp.initializeApp(PedidosRealizados.this);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = mFirebaseDatabase.getReference();
    }

    public void pesquisaBanco() {
        Query query;

        query = mDatabase.child("pedidos");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                   PedidoModelTest pedidos = objSnapshot.getValue(PedidoModelTest.class);
                    listPedidos.add(pedidos);
                }


                adapter = new PedidosRealizadosAdapter(getApplicationContext(), listPedidos);
                mListPedidosRealizados.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void onBackPressed() {
        startActivity(new Intent(PedidosRealizados.this, menu_opcoes_cliente.class));
    }


}
