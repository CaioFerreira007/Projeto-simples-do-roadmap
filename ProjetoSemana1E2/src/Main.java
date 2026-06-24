import entities.*;
import enums.TipoPagamento;
import services.PagamentoService;
import services.utils.PagamentoBoleto;
import services.utils.PagamentoCartao;
import services.utils.PagamentoPix;

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
    Map<Integer, Pedido> pedidos = new HashMap<>();
    List<ItemPedido> items = new ArrayList<>();

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
            }else{
                System.out.println("Cliente já cadastrado!");
            }
                clientes.forEach( c -> System.out.println(c.toString()));
               menu();
               opcao = sc.nextInt();
               break;
           case 2:
               System.out.println("Digite o id do produto:");
               int idProduto = sc.nextInt();
               Produto buscaProduto = produtos.stream().filter(p -> p.getId().equals(idProduto)).findFirst().orElse(null);

               System.out.println("Digite o nome do produto:");
               String nomeProduto = sc.nextLine();
               sc.nextLine();
               System.out.println("Digite o valor do produto:");
               double valorProduto = sc.nextDouble();
               if(buscaProduto == null){
                   buscaProduto = new Produto(idProduto, nomeProduto, valorProduto);
                   produtos.add(buscaProduto);
               }else{
                   System.out.println("Produto já cadastrado!");
               }
               menu();

               opcao = sc.nextInt();
               break;

           case 3:
               System.out.println("=== CRIE UM PEDIDO ===");
               System.out.println();
               System.out.println("Digite o id do pedido:");
               int idPedido = sc.nextInt();
               System.out.println("O id do cliente que vai comprar:");
               int idClientePedido = sc.nextInt();
               Cliente clientePedido = clientes.stream().filter( c -> c.getId().equals(idClientePedido)).findFirst().orElse(null);
               if(clientePedido == null){
                   System.out.println("Cliente não cadastrado!");
                   menu();
                   opcao = sc.nextInt();
               }
               System.out.println("Digite o id do produto:");
               int idProdutoPedido = sc.nextInt();
               Produto produtoPedido = produtos.stream().filter( c -> c.getId().equals(idProdutoPedido)).findFirst().orElse(null);
               if(produtoPedido == null){
                   System.out.println("Produto não cadastrado!");
                   menu();
                   opcao = sc.nextInt();
               }
           System.out.println("Digite a quantidade requerida do produto:");
           int quantidade = sc.nextInt();
               ItemPedido itemPedido = new ItemPedido(produtoPedido,quantidade);
               items.add(itemPedido);

               System.out.println("Digite a forma de pagamento: (BOLETO/PIX/CARTAO) ");
               String formaPagamento = sc.next();

               TipoPagamento tipoPagamento = TipoPagamento.valueOf(formaPagamento);
               PagamentoService servicoEscolhido = null;

               switch (tipoPagamento) {
                   case PIX:
                       servicoEscolhido = new PagamentoPix();
                       break;
                   case CARTAO:
                       servicoEscolhido = new PagamentoCartao();
                       break;
                   case BOLETO:
                       servicoEscolhido = new PagamentoBoleto();
                       break;
               }

           Pedido buscaPedido =  pedidos.containsKey(idPedido) ? pedidos.get(idPedido) : null;

           if(buscaPedido == null){
               buscaPedido = new Pedido(idPedido,clientePedido,items);
               pedidos.put(idPedido,buscaPedido);
           }

               double valorPago = items.stream()
                       .mapToDouble(i -> i.getQuantidade() * i.getProduto().getValorUnitario())
                       .sum();
               Pagamento novoPagamento = new Pagamento(buscaPedido, servicoEscolhido, 0.0);
               System.out.println("Pedido e Pagamento registrados com sucesso!");

       }


    }

  static  void menu(){
        System.out.println(" 1 - Cadastrar Cliente");
        System.out.println(" 2 - Cadastrar Produto");
        System.out.println("3 - Criar Pedido");
        System.out.println("0 - Sair");
    }

}