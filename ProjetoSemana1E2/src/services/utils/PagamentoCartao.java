package services.utils;

import entities.Pagamento;
import enums.TipoPagamento;
import services.PagamentoService;

public class PagamentoCartao implements PagamentoService {
    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento feito com cartão de crédito!");
    }

    @Override
    public TipoPagamento getTipoPagamento() {
        return TipoPagamento.CARTAO;
    }
}
