package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Helper.AttributesLista;

/**
 * Created by Adriano on 23/11/2017.
 */

public class PedidoModelTest {

    private List<AttributesLista> listaPedidosFinalizar = new ArrayList<AttributesLista>();
    private double totalPedidoFinalizado;
    private String statusFinalizado;
    private String emailFinalizado;
    private String uidFinalizado;
    private String dataFinalizarPedido;

    public PedidoModelTest() {
    }

    public PedidoModelTest(List<AttributesLista> listaPedidosFinalizar, double totalPedidoFinalizado, String statusFinalizado, String emailFinalizado, String uidFinalizado, String dataFinalizarPedido) {
        this.listaPedidosFinalizar = listaPedidosFinalizar;
        this.totalPedidoFinalizado = totalPedidoFinalizado;
        this.statusFinalizado = statusFinalizado;
        this.emailFinalizado = emailFinalizado;
        this.uidFinalizado = uidFinalizado;
        this.dataFinalizarPedido = dataFinalizarPedido;
    }

    public List<AttributesLista> getListaPedidosFinalizar() {
        return listaPedidosFinalizar;
    }

    public void setListaPedidos(List<AttributesLista> listaPedidosFinalizar) {
        this.listaPedidosFinalizar = listaPedidosFinalizar;
    }

    public double getTotalPedidoFinalizado() {
        return totalPedidoFinalizado;
    }

    public void setTotalPedidoFinalizado(double totalPedidoFinalizado) {
        this.totalPedidoFinalizado = totalPedidoFinalizado;
    }

    public String getStatusFinalizado() {
        return statusFinalizado;
    }

    public void setStatusFinalizado(String statusFinalizado) {
        this.statusFinalizado = statusFinalizado;
    }

    public String getEmailFinalizado() {
        return emailFinalizado;
    }

    public void setEmailFinalizado(String emailFinalizado) {
        this.emailFinalizado = emailFinalizado;
    }

    public String getUidFinalizado() {
        return uidFinalizado;
    }

    public void setUidFinalizado(String uidFinalizado) {
        this.uidFinalizado = uidFinalizado;
    }

    public void setListaPedidosFinalizar(List<AttributesLista> listaPedidosFinalizar) {
        this.listaPedidosFinalizar = listaPedidosFinalizar;
    }

    public String getDataFinalizarPedido() {
        return dataFinalizarPedido;
    }

    public void setDataFinalizarPedido(String dataFinalizarPedido) {
        this.dataFinalizarPedido = dataFinalizarPedido;
    }
}
