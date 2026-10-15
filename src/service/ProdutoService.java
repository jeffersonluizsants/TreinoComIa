package service;

import model.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    List<Produto> estoque = new ArrayList<>();

    public ProdutoService(){

    }

    public Produto buscarProdutoPorId(Long id){
        for (Produto item : estoque){
            if (item.getIdProduto().equals(id)){
                return item;
            }
        }
        return null;
    }
    public boolean cadastrarProduto(Produto produto){
        if (produto == null){
            return false;
        }
        if (buscarProdutoPorId(produto.getIdProduto()) != null || buscarProdutoPorId(produto.getIdProduto()) <null){
            return false;
        }
        if (produto.getNomeProduto().isBlank() || produto.getNomeProduto() == null){
            return false;
        }
        if (produto.getPrecoProduto() == null){
            return false;
        }
        if (produto.getPrecoProduto().compareTo(BigDecimal.ZERO) <0 || produto.getQuantidadeProduto() < 0){
            return false;
        }

        estoque.add(produto);

        return true;
    }
    public List<Produto> listarProdutos() {
        List<Produto> estoqueCopia = new ArrayList<>(estoque);
        return estoqueCopia;
    }
    public boolean adicionarEstoque(Long id,int quantidadeEntrada ){
       Produto produto = buscarProdutoPorId(id);
        if (produto == null){
            return false;
             }if(quantidadeEntrada > 0){
                int quantidadeAtual = produto.getQuantidadeProduto();
                int entradaDoProduto = quantidadeAtual+quantidadeEntrada;
                produto.setQuantidadeProduto(entradaDoProduto);
             }else {
                     return false;
        }
        return true;
    }
    public boolean retirarEstoque(Long id, int quantidadeRetirada){
        Produto produto = buscarProdutoPorId(id);
        if (produto == null){
            return false;
        }
        int quantidadeAtual = produto.getQuantidadeProduto();
        if (quantidadeRetirada <= 0 || quantidadeRetirada > quantidadeAtual){
            return false;
        }
        int quantidadeAbatida = quantidadeAtual -quantidadeRetirada;
        produto.setQuantidadeProduto(quantidadeAbatida);
        return true;
    }
    public boolean excluirProduto(Long id){
        Produto produto = buscarProdutoPorId(id);
        if (produto == null){
            return false;
        }
            estoque.remove(produto);
            return true;

    }

}