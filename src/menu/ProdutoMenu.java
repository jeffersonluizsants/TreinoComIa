package menu;

import model.Produto;
import service.ProdutoService;

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
                    System.out.println("Cadastrar produto");
                    break;
                case 2:
                    List<Produto> produtos = produtoService.listarProdutos();
                    if (produtos==null){
                        System.out.println("Estoque vazio!");
                    }else {
                        System.out.println(produtos);
                    }
                    System.out.println(produtoService.listarProdutos());
                    break;
                case 3:
                    System.out.println("uscar produto por ID");
                    break;
                case 4:
                    System.out.println("Adicionar estoque");
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

