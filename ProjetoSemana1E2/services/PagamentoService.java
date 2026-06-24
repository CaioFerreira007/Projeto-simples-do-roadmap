package services;

import entities.Pagamento;
import enums.TipoPagamento;

public interface PagamentoService {

    public void realizarPagamento();
    public TipoPagamento getTipoPagamento();
    public Double calcularValorPago(Double valor);

}
