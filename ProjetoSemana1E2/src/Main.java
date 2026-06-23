import entities.Cliente;
import entities.Produto;

import java.awt.*;
import java.util.*;
import java.util.List;

class Main{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        menu();
       int opcao = sc.nextInt();

    List<Cliente> clientes = new ArrayList<>();
    Set<Produto> produtos = new HashSet<>();

       switch (opcao){
           case 1:
               System.out.println("=== CADASTRO DE CLIENTE ===");
               System.out.println();
               System.out.println("Digite o id do cliente:");
               int idCliente = sc.nextInt();
               sc.nextLine();

               System.out.println("Digite o nome do cliente:");
               String nome = sc.nextLine();

               System.out.println("Digite o número de telefone do cliente:");
               String telefone = sc.next();
               sc.nextLine();

               System.out.println("Digite a cidade do cliente:");
               String cidade = sc.nextLine();
                Cliente buscaCliente;
                buscaCliente = clientes.stream().filter( c -> c.getId().equals(idCliente)).findFirst().orElse(null);
            if(buscaCliente == null){
                buscaCliente = new Cliente(idCliente, nome, telefone, cidade);
                clientes.add(buscaCliente);
            }
                clientes.forEach( c -> System.out.println(c.toString()));
               break;
           case 2:
               System.out.println("Digite o id do produto:");
               int idProduto = sc.nextInt();
               System.out.println("Digite o nome do produto:");
               String nomeProduto = sc.nextLine();
               sc.nextLine();
               System.out.println("Digite o valor do produto:");
               double valorProduto = sc.nextDouble();
                Produto produto = new Produto(idProduto, nomeProduto, valorProduto);
                produtos.add(produto);

               break;

           case 3:
               System.out.println("=== CRIE UM PEDIDO ===");

       }



    }

  static  void menu(){
        System.out.println(" 1 - Cadastrar Cliente");
        System.out.println(" 2 - Cadastrar Produto");
        System.out.println("3 - Criar Pedido");
        System.out.println("0 - Sair");
    }

}