
# Sistema de E-commerce - Demonstração DIP

Este projeto é uma demonstração simples de um sistema de e-commerce em Java que implementa o Princípio de Inversão de Dependência (DIP) do SOLID.

## Sobre o Projeto

O sistema permite:
- Selecionar produtos
- Adicionar produtos ao carrinho
- Escolher diferentes métodos de pagamento
- Finalizar a compra

A aplicação demonstra como utilizar interfaces e injeção de dependência para desacoplar componentes de alto nível (como a classe `Compra`) de implementações concretas de baixo nível (como os diferentes métodos de pagamento).

## Estrutura do Projeto

- `com.ecommerce.modelo`: Classes de modelo como `Produto` e `ItemCarrinho`
- `com.ecommerce.carrinho`: Implementação do carrinho de compras
- `com.ecommerce.compra`: Lógica de finalização da compra
- `com.ecommerce.pagamento`: Interface e implementações de métodos de pagamento

## Como Executar

Para executar o projeto, basta clicar duas vezes no arquivo `run.bat` ou executar os seguintes comandos no terminal:

```
javac -d out @sources.txt
java -cp out com.ecommerce.Main
```

## Métodos de Pagamento Disponíveis

1. Cartão de Crédito
2. Boleto Bancário
3. PIX

## Princípio de Inversão de Dependência

Este projeto demonstra o DIP através da interface `ProcessadorPagamento`, que permite que a classe `Compra` dependa de uma abstração e não de implementações concretas. Isso facilita a adição de novos métodos de pagamento sem modificar a lógica de negócio principal.