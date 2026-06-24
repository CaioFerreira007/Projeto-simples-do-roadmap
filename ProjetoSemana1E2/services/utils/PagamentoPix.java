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

    @Override
    public Double calcularValorPago(Double valor) {
        return valor * 0.9;
    }
}
