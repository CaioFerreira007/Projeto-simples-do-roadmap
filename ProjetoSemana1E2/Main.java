import entities.*;
import enums.TipoPagamento;
import middlewares.ErroGeralException;
import services.PagamentoService;
import services.utils.PagamentoBoleto;
import services.utils.PagamentoCartao;
import services.utils.PagamentoPix;

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
        while(opcao != 0) {
            try{

            switch (opcao) {
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
                    buscaCliente = clientes.stream().filter(c -> c.getId().equals(idCliente)).findFirst().orElse(null);
                    if (buscaCliente == null) {
                        buscaCliente = new Cliente(idCliente, nome, telefone, cidade);
                        clientes.add(buscaCliente);
                    } else {
                        System.out.println("Cliente já cadastrado!");
                    }
                    clientes.forEach(c -> System.out.println(c.toString()));
                    menu();
                    opcao = sc.nextInt();
                    break;
                case 2:
                    System.out.println("Digite o id do produto:");
                    int idProduto = sc.nextInt();
                    Produto buscaProduto = produtos.stream().filter(p -> p.getId().equals(idProduto)).findFirst().orElse(null);
                    sc.nextLine();
                    System.out.println("Digite o nome do produto:");
                    String nomeProduto = sc.nextLine();
                    System.out.println("Digite o valor do produto:");
                    double valorProduto = sc.nextDouble();
                    if (buscaProduto == null) {
                        buscaProduto = new Produto(idProduto, nomeProduto, valorProduto);
                        produtos.add(buscaProduto);
                    } else {
                        throw new ErroGeralException("Produto já cadastrado!");
                    }
                    menu();

                    opcao = sc.nextInt();
                    break;

                case 3:
                    List<ItemPedido> items = new ArrayList<>();

                    System.out.println("=== CRIE UM PEDIDO ===");
                    System.out.println();
                    System.out.println("Digite o id do pedido:");
                    int idPedido = sc.nextInt();
                    System.out.println("O id do cliente que vai comprar:");
                    int idClientePedido = sc.nextInt();
                    Cliente clientePedido = clientes.stream().filter(c -> c.getId().equals(idClientePedido)).findFirst().orElse(null);
                    if (clientePedido == null) {
                        throw new NullPointerException("Cliente não cadastrado!");
                    }

                    System.out.println("Digite o id do produto:");
                    int idProdutoPedido = sc.nextInt();
                    Produto produtoPedido = produtos.stream().filter(c -> c.getId().equals(idProdutoPedido)).findFirst().orElse(null);
                    if (produtoPedido == null) {
                        throw new NullPointerException("Produto não cadastrado!");
                    }

                    System.out.println("Digite a quantidade requerida do produto:");
                    int quantidade = sc.nextInt();
                    ItemPedido itemPedido = new ItemPedido(produtoPedido, quantidade);
                    items.add(itemPedido);

                    System.out.println("Digite a forma de pagamento: (BOLETO/PIX/CARTAO) ");
                    String formaPagamento = sc.next().toUpperCase();

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

                    Pedido buscaPedido = pedidos.containsKey(idPedido) ? pedidos.get(idPedido) : null;

                    if (buscaPedido == null) {
                        buscaPedido = new Pedido(idPedido, clientePedido, items);
                        pedidos.put(idPedido, buscaPedido);
                    }else {
                        buscaPedido.addItemPedido(itemPedido);
                    }

             buscaPedido.calcularTotal();

                    Pagamento novoPagamento = new Pagamento(buscaPedido, servicoEscolhido, servicoEscolhido.calcularValorPago(buscaPedido.calcularTotal()));
                    buscaPedido.addPagamento(novoPagamento);
                    System.out.println("O valor a ser pago é de: " + String.format("%.2f", servicoEscolhido.calcularValorPago(buscaPedido.calcularTotal())));
                    servicoEscolhido.realizarPagamento();
                    System.out.println();
                    System.out.println("Pedido e Pagamento registrados com sucesso!");
                    menu();
                    opcao = sc.nextInt();
                    break;

                case 4:
                    System.out.println("=== RELATÓRIOS ===");
                    System.out.println("Digite o id do pedido:");
                    int idPedidoRelatorio = sc.nextInt();
                    Pedido pedidoRelatorio = pedidos.get(idPedidoRelatorio);
                    if (pedidoRelatorio != null) {
                        System.out.println(pedidoRelatorio.toString());
                    }else{
                            throw new ErroGeralException("Pedido não encontrado!");
                    }

                    menu();
                    opcao = sc.nextInt();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;


            }
        }catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite apenas números!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: Forma de pagamento inválida! Digite PIX, CARTAO ou BOLETO.");
            }
}


    }
    static  void menu(){
        System.out.println(" 1 - Cadastrar Cliente");
        System.out.println(" 2 - Cadastrar Produto");
        System.out.println("3 - Criar Pedido");
        System.out.println("4 - Gerar Relatório");
        System.out.println("0 - Sair");
    }

}