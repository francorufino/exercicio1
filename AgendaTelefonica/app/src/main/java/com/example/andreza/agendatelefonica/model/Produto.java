package com.example.andreza.agendatelefonica.model;


public class Produto {
    private String nomeDoProduto;
    private String nomeDaLoja;
    private String enderecoLoja;
    private Double precoDoProduto;
    private String notasSobreOProduto;

//    todo: nao soube usar esse. eu nao soube onde colocar ele nas outras tabs. =(
    public static Produto generateProduct() {
        Produto produto = new Produto();
        produto.setNomeDaLoja("");
        produto.setEnderecoLoja("");
        produto.setNomeDoProduto("");
        produto.setNotasSobreOProduto("");
        produto.setPrecoDoProduto(0.0);
        return produto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public Double getPrecoDoProduto() {
        return precoDoProduto;
    }

    public void setPrecoDoProduto(Double precoDoProduto) {
        this.precoDoProduto = precoDoProduto;
    }

    public String getNomeDaLoja() {
        return nomeDaLoja;
    }

    public void setNomeDaLoja(String nomeDaLoja) {
        this.nomeDaLoja = nomeDaLoja;
    }

    public String getNotasSobreOProduto() {
        return notasSobreOProduto;
    }

    public void setNotasSobreOProduto(String notasSobreOProduto) {
        this.notasSobreOProduto = notasSobreOProduto;
    }

    public String getEnderecoLoja() {
        return enderecoLoja;
    }

    public void setEnderecoLoja(String enderecoLoja) {
        this.enderecoLoja = enderecoLoja;
    }
}
