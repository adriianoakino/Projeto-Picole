package Model;


import android.app.ListActivity;

import com.company.tudodebom.tudodebom.R;
import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Helper.ListAtributes;

/**
 * Created by Adriano on 21/09/2017.
 */

public class CarrinhoComprasModel {


    //private List<ListAtributes> listaCompra;
    private HashMap<String,ListAtributes> listaCompra;


    private String nomes[] = {"Abaxi Hawai",
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
        R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo};

    /*private int id;
    private int quantidadePicole;
    private double totalPreco;

    public List<ListAtributes> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<ListAtributes> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadePicole() {
        return quantidadePicole;
    }

    public void setQuantidadePicole(int quantidadePicole) {
        this.quantidadePicole = quantidadePicole;
    }

    public double getTotalPreco() {
        return totalPreco;
    }

    public void setTotalPreco(double totalPreco) {
        this.totalPreco = totalPreco;
    }*/

    private Double precoAbacaxiHawai;
    private Double precoAbacaxiVinho;
    private Double precoAmendoim;
    private Double precoChocolate;
    private Double precoCocoBranco;
    private Double precoCocoQueimado;
    private Double precoGourmetBanana;
    private Double precoGoiabaLeite;
    private Double precoLeiteCondensado;
    private Double precoMilhoVerde;
    private Double precoMorangoStar;
    private Double precoMousseMaracuja;
    private Double precoSkimo;
    private Double precoLeiteNinho;
    private Double precoTortaLimao;
    private Double precoUva;

    private Integer quantidadeAbacaxiHawai;
    private Integer quantidadeAbacaxiVinho;
    private Integer quantidadeAmendoim;
    private Integer quantidadeChocolate;
    private Integer quantidadeCocoBranco;
    private Integer quantidadeCocoQueimado;
    private Integer quantidadeGourmetBanana;
    private Integer quantidadeGoiabaLeite;
    private Integer quantidadeLeiteCondensado;
    private Integer quantidadeMilhoVerde;
    private Integer quantidadeMorangoStar;
    private Integer quantidadeMousseMaracuja;
    private Integer quantidadeSkimo;
    private Integer quantidadeLeiteNinho;
    private Integer quantidadeTortaLimao;
    private Integer quantidadeUva;

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

    public Double getPrecoAbacaxiHawai() {
        return precoAbacaxiHawai;
    }

    public void setPrecoAbacaxiHawai(Double precoAbacaxiHawai) {
        this.precoAbacaxiHawai = precoAbacaxiHawai;
    }

    public Double getPrecoAbacaxiVinho() {
        return precoAbacaxiVinho;
    }

    public void setPrecoAbacaxiVinho(Double precoAbacaxiVinho) {
        this.precoAbacaxiVinho = precoAbacaxiVinho;
    }

    public Double getPrecoAmendoim() {
        return precoAmendoim;
    }

    public void setPrecoAmendoim(Double precoAmendoim) {
        this.precoAmendoim = precoAmendoim;
    }

    public Double getPrecoChocolate() {
        return precoChocolate;
    }

    public void setPrecoChocolate(Double precoChocolate) {
        this.precoChocolate = precoChocolate;
    }

    public Double getPrecoCocoBranco() {
        return precoCocoBranco;
    }

    public void setPrecoCocoBranco(Double precoCocoBranco) {
        this.precoCocoBranco = precoCocoBranco;
    }

    public Double getPrecoCocoQueimado() {
        return precoCocoQueimado;
    }

    public void setPrecoCocoQueimado(Double precoCocoQueimado) {
        this.precoCocoQueimado = precoCocoQueimado;
    }

    public Double getPrecoGourmetBanana() {
        return precoGourmetBanana;
    }

    public void setPrecoGourmetBanana(Double precoGourmetBanana) {
        this.precoGourmetBanana = precoGourmetBanana;
    }

    public Double getPrecoGoiabaLeite() {
        return precoGoiabaLeite;
    }

    public void setPrecoGoiabaLeite(Double precoGoiabaLeite) {
        this.precoGoiabaLeite = precoGoiabaLeite;
    }

    public Double getPrecoLeiteCondensado() {
        return precoLeiteCondensado;
    }

    public void setPrecoLeiteCondensado(Double precoLeiteCondensado) {
        this.precoLeiteCondensado = precoLeiteCondensado;
    }

    public Double getPrecoMilhoVerde() {
        return precoMilhoVerde;
    }

    public void setPrecoMilhoVerde(Double precoMilhoVerde) {
        this.precoMilhoVerde = precoMilhoVerde;
    }

    public Double getPrecoMorangoStar() {
        return precoMorangoStar;
    }

    public void setPrecoMorangoStar(Double precoMorangoStar) {
        this.precoMorangoStar = precoMorangoStar;
    }

    public Double getPrecoMousseMaracuja() {
        return precoMousseMaracuja;
    }

    public void setPrecoMousseMaracuja(Double precoMousseMaracuja) {
        this.precoMousseMaracuja = precoMousseMaracuja;
    }

    public Double getPrecoSkimo() {
        return precoSkimo;
    }

    public void setPrecoSkimo(Double precoSkimo) {
        this.precoSkimo = precoSkimo;
    }

    public Double getPrecoLeiteNinho() {
        return precoLeiteNinho;
    }

    public void setPrecoLeiteNinho(Double precoLeiteNinho) {
        this.precoLeiteNinho = precoLeiteNinho;
    }

    public Double getPrecoTortaLimao() {
        return precoTortaLimao;
    }

    public void setPrecoTortaLimao(Double precoTortaLimao) {
        this.precoTortaLimao = precoTortaLimao;
    }

    public Double getPrecoUva() {
        return precoUva;
    }

    public void setPrecoUva(Double precoUva) {
        this.precoUva = precoUva;
    }

    public Integer getQuantidadeAbacaxiHawai() {
        return quantidadeAbacaxiHawai;
    }

    public void setQuantidadeAbacaxiHawai(Integer quantidadeAbacaxiHawai) {
        this.quantidadeAbacaxiHawai = quantidadeAbacaxiHawai;
    }

    public Integer getQuantidadeAbacaxiVinho() {
        return quantidadeAbacaxiVinho;
    }

    public void setQuantidadeAbacaxiVinho(Integer quantidadeAbacaxiVinho) {
        this.quantidadeAbacaxiVinho = quantidadeAbacaxiVinho;
    }

    public Integer getQuantidadeAmendoim() {
        return quantidadeAmendoim;
    }

    public void setQuantidadeAmendoim(Integer quantidadeAmendoim) {
        this.quantidadeAmendoim = quantidadeAmendoim;
    }

    public Integer getQuantidadeChocolate() {
        return quantidadeChocolate;
    }

    public void setQuantidadeChocolate(Integer quantidadeChocolate) {
        this.quantidadeChocolate = quantidadeChocolate;
    }

    public Integer getQuantidadeCocoBranco() {
        return quantidadeCocoBranco;
    }

    public void setQuantidadeCocoBranco(Integer quantidadeCocoBranco) {
        this.quantidadeCocoBranco = quantidadeCocoBranco;
    }

    public Integer getQuantidadeCocoQueimado() {
        return quantidadeCocoQueimado;
    }

    public void setQuantidadeCocoQueimado(Integer quantidadeCocoQueimado) {
        this.quantidadeCocoQueimado = quantidadeCocoQueimado;
    }

    public Integer getQuantidadeGourmetBanana() {
        return quantidadeGourmetBanana;
    }

    public void setQuantidadeGourmetBanana(Integer quantidadeGourmetBanana) {
        this.quantidadeGourmetBanana = quantidadeGourmetBanana;
    }

    public Integer getQuantidadeGoiabaLeite() {
        return quantidadeGoiabaLeite;
    }

    public void setQuantidadeGoiabaLeite(Integer quantidadeGoiabaLeite) {
        this.quantidadeGoiabaLeite = quantidadeGoiabaLeite;
    }

    public Integer getQuantidadeLeiteCondensado() {
        return quantidadeLeiteCondensado;
    }

    public void setQuantidadeLeiteCondensado(Integer quantidadeLeiteCondensado) {
        this.quantidadeLeiteCondensado = quantidadeLeiteCondensado;
    }

    public Integer getQuantidadeMilhoVerde() {
        return quantidadeMilhoVerde;
    }

    public void setQuantidadeMilhoVerde(Integer quantidadeMilhoVerde) {
        this.quantidadeMilhoVerde = quantidadeMilhoVerde;
    }

    public Integer getQuantidadeMorangoStar() {
        return quantidadeMorangoStar;
    }

    public void setQuantidadeMorangoStar(Integer quantidadeMorangoStar) {
        this.quantidadeMorangoStar = quantidadeMorangoStar;
    }

    public Integer getQuantidadeMousseMaracuja() {
        return quantidadeMousseMaracuja;
    }

    public void setQuantidadeMousseMaracuja(Integer quantidadeMousseMaracuja) {
        this.quantidadeMousseMaracuja = quantidadeMousseMaracuja;
    }

    public Integer getQuantidadeSkimo() {
        return quantidadeSkimo;
    }

    public void setQuantidadeSkimo(Integer quantidadeSkimo) {
        this.quantidadeSkimo = quantidadeSkimo;
    }

    public Integer getQuantidadeLeiteNinho() {
        return quantidadeLeiteNinho;
    }

    public void setQuantidadeLeiteNinho(Integer quantidadeLeiteNinho) {
        this.quantidadeLeiteNinho = quantidadeLeiteNinho;
    }

    public Integer getQuantidadeTortaLimao() {
        return quantidadeTortaLimao;
    }

    public void setQuantidadeTortaLimao(Integer quantidadeTortaLimao) {
        this.quantidadeTortaLimao = quantidadeTortaLimao;
    }

    public Integer getQuantidadeUva() {
        return quantidadeUva;
    }

    public void setQuantidadeUva(Integer quantidadeUva) {
        this.quantidadeUva = quantidadeUva;
    }

    public HashMap<String, ListAtributes> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(HashMap<String, ListAtributes> listaCompra) {
        this.listaCompra = listaCompra;
    }

   /* public Map<String, ListAtributes> toMap(){
        listaCompra = new HashMap<>();

        listaCompra.put("Abacaxi Hawai",        new ListAtributes(getQuantidadeAbacaxiHawai(), getPrecoAbacaxiHawai()));
        listaCompra.put("Abacaxi ao Vinho",     new ListAtributes(getQuantidadeAbacaxiVinho(), getPrecoAbacaxiVinho()));
        listaCompra.put("Amendoim",             new ListAtributes(getQuantidadeAmendoim(), getPrecoAmendoim()));
        listaCompra.put("Chocolate",            new ListAtributes(getQuantidadeChocolate(), getPrecoChocolate()));
        listaCompra.put("Coco Branco",          new ListAtributes(getQuantidadeCocoBranco(), getPrecoCocoBranco()));
        listaCompra.put("Coco Queimado",        new ListAtributes(getQuantidadeCocoQueimado(), getPrecoCocoQueimado()));
        listaCompra.put("Gourmet Banana",       new ListAtributes(getQuantidadeGourmetBanana(), getPrecoGourmetBanana()));
        listaCompra.put("Goiaba ao Leite",      new ListAtributes(getQuantidadeGoiabaLeite(), getPrecoGoiabaLeite()));
        listaCompra.put("LeiteCondensado",      new ListAtributes(getQuantidadeLeiteCondensado(), getPrecoLeiteCondensado()));
        listaCompra.put("Milho Verde",          new ListAtributes(getQuantidadeMilhoVerde(), getPrecoMilhoVerde()));
        listaCompra.put("Morango Star",         new ListAtributes(getQuantidadeMorangoStar(), getPrecoMorangoStar()));
        listaCompra.put("Mousse Maracujá",      new ListAtributes(getQuantidadeMousseMaracuja(), getPrecoMousseMaracuja()));
        listaCompra.put("Skimo de Leitinho",    new ListAtributes(getQuantidadeSkimo(), getPrecoSkimo()));
        listaCompra.put("Torta de Limão",       new ListAtributes(getQuantidadeTortaLimao(), getPrecoTortaLimao()));
        listaCompra.put("Uva",                  new ListAtributes(getQuantidadeUva(), getPrecoUva()));

       // listaCompra.add(new ListAtributes(getId(), getQuantidadePicole(), getTotalPreco()));

        return listaCompra;
    }*/



}
