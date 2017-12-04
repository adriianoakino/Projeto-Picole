package Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.company.tudodebom.tudodebom.R;

import java.util.List;

import Model.PedidoModelTest;

/**
 * Created by Adriano on 03/12/2017.
 */

public class PedidosRealizadosAdapter extends BaseAdapter {

    private Context mContext;
    private List<PedidoModelTest> mListPedidosRealizados;

    //

    public PedidosRealizadosAdapter(Context mContext, List<PedidoModelTest> mListPedidosRealizados) {
        this.mContext = mContext;
        this.mListPedidosRealizados = mListPedidosRealizados;
    }

    @Override
    public int getCount() {
        return mListPedidosRealizados.size();
    }

    @Override
    public Object getItem(int position) {
        return mListPedidosRealizados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = View.inflate(mContext,R.layout.listview_pedidos_realizados, null);
        TextView txtDataCompra = (TextView) v.findViewById(R.id.txtDataCompra);
        TextView txtTotalCompra = (TextView) v.findViewById(R.id.txtPrecoCompra);
        TextView txtPedido = (TextView) v.findViewById(R.id.txtPedido);
        ProgressBar status = (ProgressBar)  v.findViewById(R.id.statusEntrega);

        txtDataCompra.setText(String.valueOf(mListPedidosRealizados.get(position).getDataFinalizarPedido()));
        txtTotalCompra.setText(String.valueOf(mListPedidosRealizados.get(position).getTotalPedidoFinalizado()));
        txtPedido.setText("Pedido " + String.valueOf(position+1));
        if(mListPedidosRealizados.get(position).getStatusFinalizado().equals("Aberto")){
            status.setProgress(30);
            status.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
        }else if(mListPedidosRealizados.get(position).getStatusFinalizado().equals("Entrega")){
            status.setProgress(70);
            status.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
        }else if(mListPedidosRealizados.get(position).getStatusFinalizado().equals("Fechado")){
            status.setProgress(100);
            status.setProgressTintList(ColorStateList.valueOf(Color.RED));
        }

        return v;
    }
}
