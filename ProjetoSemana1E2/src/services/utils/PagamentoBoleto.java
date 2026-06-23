package services.utils;

import entities.Pagamento;
import enums.TipoPagamento;
import services.PagamentoService;

public class PagamentoBoleto implements PagamentoService {

    private final double jurosBoleto = 1.3;

    @Override
    public void realizarPagamento() {

        System.out.println("Pagamento realizado com boleto");
    }

    @Override
    public TipoPagamento getTipoPagamento() {
        return TipoPagamento.BOLETO;
    }
}
