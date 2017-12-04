package Helper;

/**
 * Created by Adriano on 02/10/2017.
 */

public class AttributesLista {

    private int id;
    private int quantidade;
    private double preco;

    public AttributesLista(int id, int quantidade, double preco){
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public  AttributesLista() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
