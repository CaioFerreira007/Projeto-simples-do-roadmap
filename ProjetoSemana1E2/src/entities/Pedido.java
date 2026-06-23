package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pedido {

    private Cliente cliente;
    private List<ItemPedido> itemPedido = new ArrayList<>();
    private Set<Pagamento> pagamentos = new HashSet<>();

    public Pedido(Cliente cliente, List<ItemPedido> itemPedido, Set<Pagamento> pagamentos) {
        this.cliente = cliente;
        this.itemPedido = itemPedido;
        this.pagamentos = pagamentos;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public Set<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void addItemPedido(ItemPedido itemPedido) {
        this.itemPedido.add(itemPedido);
    }

    public void removeItemPedido(ItemPedido itemPedido) {
        this.itemPedido.remove(itemPedido);
    }

}
