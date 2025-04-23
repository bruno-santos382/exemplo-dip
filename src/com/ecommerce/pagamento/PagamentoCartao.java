package com.ecommerce.pagamento;

public class PagamentoCartao implements ProcessadorPagamento {
    private String numeroCartao;
    
    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    
    @Override
    public boolean processar(double valor) {
        System.out.println("Processando pagamento com Cartão no valor de R$ " + valor);
        System.out.println("Cartão: " + numeroCartao.substring(0, 4) + " **** **** " +
                numeroCartao.substring(numeroCartao.length() - 4));
        System.out.println("Pagamento com cartão realizado com sucesso!");
        return true;
    }
    
    @Override
    public String getMetodoPagamento() {
        return "Cartão";
    }
}