package Model;


import com.company.tudodebom.tudodebom.R;

/**
 * Created by Adriano on 21/09/2017.
 */

public class CarrinhoComprasModel {

    private String nomes[] = {
            "Abaxi Hawai",
            "Abacaxi ao Vinho",
            "Amendoim",
            "Chocolate",
            "Coco Branco",
            "Coco Queimado",
            "Gourmet Banana",
            "Goiaba ao Leite",
            "Leite Condensado",
            "Milho Verde",
            "Morango Star",
            "Mousse Maracuja",
            "Skimo",
            "Leite Ninho",
            "Torta de Limao",
            "Uva"};

    private int images[] = {
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.logo2};

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }
}
