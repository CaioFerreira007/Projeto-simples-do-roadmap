package entities;

import services.PagamentoService;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pagamento {

    private PagamentoService formaDePagamento;
    private Pedido pedido;
    private Double valorPago;

    public Pagamento(Pedido pedido, PagamentoService formaDePagamento, Double valorPago) {
        this.pedido = pedido;
        this.formaDePagamento = formaDePagamento;
        this.valorPago = valorPago;
    }
    public PagamentoService getPagamentoService(){
        return formaDePagamento;
    }
    public Pedido getPedido() {
        return pedido;
    }

    public Double getValorPago() {
        return valorPago;
    }
    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(formaDePagamento, pagamento.formaDePagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(formaDePagamento);
    }
}