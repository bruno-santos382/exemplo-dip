package com.ecommerce.compra;

import com.ecommerce.carrinho.CarrinhoCompra;
import com.ecommerce.pagamento.ProcessadorPagamento;

public class Compra {
    private CarrinhoCompra carrinho;
    private ProcessadorPagamento processador; 
    
    public Compra(CarrinhoCompra carrinho) {
        this.carrinho = carrinho;
    }
    
    // Método que injeta a dependência (DI)
    public void setProcessadorPagamento(ProcessadorPagamento processador) {
        this.processador = processador;
    }
    
    public boolean finalizarCompra() {
        if (processador == null) {
            System.out.println("Erro: método de pagamento não definido!");
            return false;
        }
        
        if (carrinho.getItens().isEmpty()) {
            System.out.println("Erro: carrinho vazio!");
            return false;
        }
        
        System.out.println("\n=== FINALIZANDO COMPRA ===");
        System.out.println(carrinho);
        
        boolean pagamentoProcessado = processador.processar(carrinho.getTotal());
        
        if (pagamentoProcessado) {
            System.out.println("\nCompra finalizada com sucesso!");
            System.out.println("Método de pagamento: " + processador.getMetodoPagamento());
            carrinho.limparCarrinho();
            return true;
        } else {
            System.out.println("\nFalha ao processar pagamento. Compra não finalizada.");
            return false;
        }
    }
}