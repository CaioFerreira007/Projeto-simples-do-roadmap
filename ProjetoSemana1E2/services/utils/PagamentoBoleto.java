package services.utils;

import entities.Pagamento;
import enums.TipoPagamento;
import services.PagamentoService;

public class PagamentoBoleto implements PagamentoService {


    @Override
    public void realizarPagamento() {

        System.out.println("Pagamento realizado com boleto");
    }

    @Override
    public TipoPagamento getTipoPagamento() {
        return TipoPagamento.BOLETO;
    }

    @Override
    public Double calcularValorPago(Double valor) {
        return valor;
    }
}
