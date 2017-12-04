package Helper;

/**
 * Created by Adriano on 19/10/2017.
 */

public class HelperHashMapPedidos {
    private String quantidade;
    private String preco;

    public HelperHashMapPedidos(String quantidade, String preco){
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
