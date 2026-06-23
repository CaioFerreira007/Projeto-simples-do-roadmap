package services.utils;

import enums.TipoPagamento;
import services.PagamentoService;

public class PagamentoPix implements PagamentoService {
    @Override
    public void realizarPagamento() {

        System.out.println("Pagamento realizado com Pix!");

    }

    @Override
    public TipoPagamento getTipoPagamento() {
        return TipoPagamento.PIX;
    }
}
