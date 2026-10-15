package menu;

import model.Produto;
import service.ProdutoService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProdutoMenu {
    ProdutoService produtoService = new ProdutoService();
    Scanner sc = new Scanner(System.in);
    public void menu(){
        boolean executando = true;
        while (executando){
            System.out.println("========== CONTROLE DE ESTOQUE ==========\n" +
                    "\n" +
                    "1 - Cadastrar produto\n" +
                    "2 - Listar produtos\n" +
                    "3 - Buscar produto por ID\n" +
                    "4 - Adicionar estoque\n" +
                    "5 - Retirar estoque\n" +
                    "6 - Excluir produto\n" +
                    "0 - Sair\n" +
                    "\n" +
                    "Escolha uma opção: ");
            int opc = sc.nextInt();

            switch (opc){
                case 1:
                    String nomeErrado = "Não foi possivel cadastrar o produto: Entrada de nome incorreta!";
                    String precoNegativo = "Não foi possivel cadastrar o produto: Preço negativo!";
                    String quantidadeNegativa = "Não foi possivel cadastrar o produto: Quantidade negativa!";
                    String idNegativo = "Não foi possivel cadastrar o produto: ID negativo!";
                    System.out.println("Digite o ID: ");
                    Long idProduct = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Digite o nome: ");
                    String nomeProduct = sc.nextLine();
                    System.out.println("Digite o preço: ");
                    BigDecimal precoProduct = sc.nextBigDecimal();
                    System.out.println("Digite a quantidade: ");
                    int quantidadeProduct = sc.nextInt();
                    if (idProduct< 0){
                        System.out.println(idNegativo);
                        break;
                    } if (nomeProduct.isBlank()) {
                        System.out.println(nomeErrado);
                        break;
                    } if (precoProduct.compareTo(BigDecimal.ZERO)<0) {
                        System.out.println(precoNegativo);
                        break;
                    } if (quantidadeProduct < 0) {
                        System.out.println(quantidadeNegativa);
                        break;
                    }
                    var product = new Produto(idProduct,nomeProduct,precoProduct,quantidadeProduct);
                    boolean resultadoCadastro = produtoService.cadastrarProduto(product);
                    if (resultadoCadastro) {
                        System.out.println("Produto cadastrado com sucesso!");
                    }else {
                        System.out.println("Não foi possivel cadastrar o produto: ID já existente!");
                    }
                    System.out.println("ID informado: " + idProduct);
                    System.out.println("Nome informado: " + nomeProduct);
                    System.out.println("Preço informado: " + precoProduct);
                    System.out.println("Quantidade informada: " + quantidadeProduct);
                    break;
                case 2:
                    List<Produto> produtos = produtoService.listarProdutos();
                    if (produtos.isEmpty()){
                        System.out.println("Estoque vazio!");
                    }else {
                        System.out.println(produtos);
                    }
                    break;
                case 3:
                    System.out.println("Insira o ID: ");
                    Long idEntrada = sc.nextLong();
                   Produto resultado = produtoService.buscarProdutoPorId(idEntrada);
                    if (resultado == null){
                        System.out.println("Produto não encontrado");
                    }else {
                        System.out.println(resultado);
                    }
                    break;
                case 4:
                    System.out.println("Selecione o ID do produto que desjea adicionar: ");
                    Long idEntradaAdicionar = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Insira a quantidade que deseja adicionar: ");
                    int quantidadeEntrada = sc.nextInt();
                    boolean resultadoEntrada =  produtoService.adicionarEstoque(idEntradaAdicionar,quantidadeEntrada);
                    if (resultadoEntrada == false){
                        System.out.println("Erro ao adicinar, tente novamente");
                    }else {
                        System.out.println("Estoque atualizado com Sucesso!");
                    }


                    break;
                case 5:
                    System.out.println("Retirar estoque");
                    break;
                case 6:
                    System.out.println("Excluir produto");
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        }
    }
}

