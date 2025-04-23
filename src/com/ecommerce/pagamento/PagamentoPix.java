package com.ecommerce.pagamento;

public class PagamentoPix implements ProcessadorPagamento {
    @Override
    public boolean processar(double valor) {
        System.out.println("Processando pagamento via PIX no valor de R$ " + valor);
        System.out.println("Chave PIX: 123456789");
        System.out.println("Pagamento PIX realizado com sucesso!");
        return true;
    }
    
    @Override
    public String getMetodoPagamento() {
        return "PIX";
    }
}