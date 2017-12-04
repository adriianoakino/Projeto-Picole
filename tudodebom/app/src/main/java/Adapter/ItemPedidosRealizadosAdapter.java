package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.company.tudodebom.tudodebom.R;

import java.util.List;

import DAO.CarrinhoCompra;
import Helper.AttributesLista;
import Model.CarrinhoComprasModel;
import Model.PedidoModelTest;

/**
 * Created by Adriano on 03/12/2017.
 */

public class ItemPedidosRealizadosAdapter extends BaseAdapter {
    private Context mContext;
    private List<PedidoModelTest> mAtributosPedido;
    private int posicao;

    CarrinhoComprasModel model = new CarrinhoComprasModel();

    public ItemPedidosRealizadosAdapter() {
    }

    public ItemPedidosRealizadosAdapter(Context mContext, List<PedidoModelTest> mAtributosPedido, int posicao) {
        this.mContext = mContext;
        this.mAtributosPedido = mAtributosPedido;
        this.posicao = posicao;
    }

    @Override
    public int getCount() {
        return mAtributosPedido.size();
    }

    @Override
    public Object getItem(int position) {
        return mAtributosPedido.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.listview_item_pedidos_realizados, null);
        TextView txtSabor = (TextView) v.findViewById(R.id.txtSaborPedido);
        TextView txtQuantidade = (TextView) v.findViewById(R.id.txtQuantidadeItenPedido);
        TextView txtPreco = (TextView) v.findViewById(R.id.txtPrecoItenAtributoPedido);
        //TextView txtData = (TextView) v.findViewById(R.id.dataItemPedidoRealizado);
        //TextView txtTotal = (TextView) v.findViewById(R.id.totalItemPedidoRealizado);


        txtSabor.setText(model.getNomes()[mAtributosPedido.get(posicao).getListaPedidosFinalizar().get(position).getId()]);
        txtQuantidade.setText(String.valueOf(mAtributosPedido.get(posicao).getListaPedidosFinalizar().get(position).getQuantidade()));
        txtPreco.setText(String.valueOf(mAtributosPedido.get(posicao).getListaPedidosFinalizar().get(position).getPreco()));
       // txtData.setText(String.valueOf(mAtributosPedido.get(posicao).getDataFinalizarPedido()));
       // txtTotal.setText(String.valueOf(mAtributosPedido.get(posicao).getTotalPedidoFinalizado()));

        return v;
    }
}
