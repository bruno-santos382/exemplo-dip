package com.ecommerce.pagamento;

public class PagamentoBoleto implements ProcessadorPagamento {
    
    private String cpf;

    public PagamentoBoleto(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean processar(double valor) {
        System.out.println("Processando pagamento via Boleto no valor de R$ " + valor);
        System.out.println("CPF: " + cpf);
        System.out.println("Código do boleto gerado: 34191.79001 12345.678901");
        System.out.println("Boleto gerado com sucesso! Aguardando pagamento.");
        return true;
    }
    
    @Override
    public String getMetodoPagamento() {
        return "Boleto Bancário";
    }
}