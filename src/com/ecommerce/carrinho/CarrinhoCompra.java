package com.ecommerce.carrinho;

import java.util.ArrayList;
import java.util.List;
import com.ecommerce.modelo.Produto;
import com.ecommerce.modelo.ItemCarrinho;

public class CarrinhoCompra {
    private List<ItemCarrinho> itens;
    
    public CarrinhoCompra() {
        this.itens = new ArrayList<>();
    }
    
    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemCarrinho(produto, quantidade));
        System.out.println("Produto adicionado: " + produto.getNome());
    }
    
    public void removerItem(int indice) {
        if (indice >= 0 && indice < itens.size()) {
            ItemCarrinho item = itens.remove(indice);
            System.out.println("Produto removido: " + item.getProduto().getNome());
        }
    }
    
    public double getTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
    
    public List<ItemCarrinho> getItens() {
        return new ArrayList<>(itens);
    }
    
    public void limparCarrinho() {
        itens.clear();
        System.out.println("Carrinho foi esvaziado");
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Itens no carrinho:\n");
        for (int i = 0; i < itens.size(); i++) {
            sb.append(i + 1).append(". ").append(itens.get(i)).append("\n");
        }
        sb.append("Total: R$ ").append(getTotal());
        return sb.toString();
    }
}