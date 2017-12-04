package Model;


import android.provider.ContactsContract;
import android.util.Log;

import com.company.tudodebom.tudodebom.PedidosRealizados;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.FirebaseConfiguration;
import Helper.AttributesLista;

/**
 * Created by Adriano on 02/10/2017.
 */

public class Pedidos extends Usuarios {

   DatabaseReference notasReferencia;
    DatabaseReference novoRegistro;

    public  static List<AttributesLista> listaPedidos = new ArrayList<AttributesLista>();
    public  static double totalPedido;
    public static String status = "Aberto";
    public static String emailPedido;
    public static String passwordPedido;
    public static FirebaseUser usuarioAtual;
    public static String uid;
    public static String criptoId;


    public Pedidos() {}




    public void registrarPedido(final String valorTotal, final String pagamento, final String troco) {


        notasReferencia = FirebaseConfiguration.getFireBase();
        novoRegistro = notasReferencia.child("pedidos").push();



        novoRegistro.child("email").setValue(emailPedido);
        novoRegistro.child("uid").setValue(uid);

        for (int i = 0; i < listaPedidos.size(); i++) {

            if (listaPedidos.get(i).getId() == 0) {
                novoRegistro.child("Abacaxi Hawai").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 1) {
                novoRegistro.child("Abacaxi ao Vinho").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 2) {
                novoRegistro.child("Amendoim").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 3) {
                novoRegistro.child("Chocolate").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 4) {
                novoRegistro.child("Coco Branco").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 5) {
                novoRegistro.child("Coco Queimado").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 6) {
                novoRegistro.child("Gourmet Banana").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 7) {
                novoRegistro.child("Goiaba ao Leite").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 8) {
                novoRegistro.child("Leite Condensado").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 9) {
                novoRegistro.child("Milho Verde").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 10) {
                novoRegistro.child("Morango Star").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 11) {
                novoRegistro.child("Mousse Maracuja").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 12) {
                novoRegistro.child("Skimo").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 13) {
                novoRegistro.child("Leite Ninho").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 14) {
                novoRegistro.child("Torta de Limão").setValue(listaPedidos.get(i).getQuantidade());
            } else if (listaPedidos.get(i).getId() == 15) {
                novoRegistro.child("Uva").setValue(listaPedidos.get(i).getQuantidade());
            }
        }

        novoRegistro.child("Valor Total").setValue(valorTotal);
        novoRegistro.child("Forma Pagamento ").setValue(pagamento);
        novoRegistro.child("Troco ").setValue(troco);
        novoRegistro.child("Status ").setValue("aberto");



    }

    public DatabaseReference pedidosRealizados() {
        DatabaseReference getDataBase = FirebaseConfiguration.getFireBase();
        DatabaseReference getRegistros = getDataBase.push().child(String.valueOf(criptoId));
        Log.d("getRegistros: ", getRegistros.toString());

        return getRegistros;


        /*FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("pedidos");*/




    }

    public void clearList() {
        listaPedidos = new ArrayList<AttributesLista>();
    }


}
