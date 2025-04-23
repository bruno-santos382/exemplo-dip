package com.ecommerce.pagamento;

/**
 * Interface para processamento de pagamentos
 * Define o contrato para diferentes implementações de processamento de pagamento
 */
public interface ProcessadorPagamento {
    /**
     * Processa um pagamento para o valor informado
     * @param valor O valor do pagamento a ser processado
     * @return true se o pagamento foi bem-sucedido, false caso contrário
     */
    boolean processar(double valor);

    /**
     * Obtém o nome/tipo do método de pagamento
     * @return String representando o método de pagamento
     */
    String getMetodoPagamento();
}