package model;

import java.math.BigDecimal;

public class Produto {
    private Long idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;
    private int quantidadeProduto;

    public Produto(Long idProduto, String nomeProduto, BigDecimal precoProduto, int quantidadeProduto){
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }
    public String getNomeProduto(){
        return nomeProduto;
    }

    public BigDecimal getPrecoProduto() {
        return precoProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        return  "Id: " + idProduto + "\n" +
                "Nome do produto: " + nomeProduto + "\n" +
                "Preço do produto: R$ " + precoProduto + "\n" +
                "Quantidade: " + quantidadeProduto;
    }
}
