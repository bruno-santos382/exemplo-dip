package com.ecommerce;

import com.ecommerce.modelo.Produto;
import com.ecommerce.carrinho.CarrinhoCompra;
import com.ecommerce.compra.Compra;
import com.ecommerce.pagamento.PagamentoCartao;
import com.ecommerce.pagamento.PagamentoBoleto;
import com.ecommerce.pagamento.PagamentoPix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando produtos fixos para demonstração
        Produto notebook = new Produto("Notebook", 3500.00);
        Produto mouse = new Produto("Mouse sem fio", 120.00);
        
        // Criando o carrinho
        CarrinhoCompra carrinho = new CarrinhoCompra();
        
        // Menu simples de produtos
        System.out.println("=== PRODUTOS DISPONÍVEIS ===");
        System.out.println("1. Notebook - R$ 3500,00");
        System.out.println("2. Mouse sem fio - R$ 120,00");
        
        // Seleção do produto
        System.out.print("Selecione um produto (1-2): ");
        int opcaoProduto = scanner.nextInt();
        
        if (opcaoProduto == 1) {
            carrinho.adicionarItem(notebook, 1);
        } else if (opcaoProduto == 2) {
            carrinho.adicionarItem(mouse, 1);
        } else {
            System.out.println("Opção inválida!");
            scanner.close();
            return;
        }
        
        // Mostra o carrinho
        System.out.println("\n=== CARRINHO ===");
        System.out.println(carrinho);
        
        // Criando a compra
        Compra compra = new Compra(carrinho);
        
        // Menu de pagamento
        System.out.println("\n=== FORMA DE PAGAMENTO ===");
        System.out.println("1. Cartão de Crédito");
        System.out.println("2. Boleto Bancário");
        System.out.println("3. Pix");
        
        // Seleção do método de pagamento
        System.out.print("Selecione a forma de pagamento (1-3): ");
        int opcaoPagamento = scanner.nextInt();
        
        // Aplicando DIP - a classe Compra depende de abstração, não de implementações concretas
        switch (opcaoPagamento) {
            case 1:
                compra.setProcessadorPagamento(new PagamentoCartao("1234-5678-9012-3456"));
                break;
            case 2:
                compra.setProcessadorPagamento(new PagamentoBoleto("123.456.789-00"));
                break;
            case 3:
                compra.setProcessadorPagamento(new PagamentoPix());
                break;
            default:
                System.out.println("Invalid payment option!");
                break;
        }

        // Finalizando a compra
        compra.finalizarCompra();
        
        scanner.close();
    }
}