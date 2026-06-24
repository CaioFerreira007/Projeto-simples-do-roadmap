package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pedido {

    private Integer idPedido;
    private Cliente cliente;
    private List<ItemPedido> itemPedido = new ArrayList<>();
    private Set<Pagamento> pagamentos = new HashSet<>();

    public Pedido(Integer idPedido,Cliente cliente, List<ItemPedido> itemPedido) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.itemPedido = itemPedido;
    }
public Integer getIdPedido() {
        return idPedido;
}
    public Cliente getCliente() {
        return cliente;
    }
    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }
public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
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
