# Offer Strategy API 🎯

Uma API REST desenvolvida com **Java 21** e **Spring Boot** para avaliação e geração dinâmica de ofertas de produtos financeiros (Crédito, Seguro e Cashback) utilizando o padrão de projeto **Strategy**.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.2.x**
    - Spring Web
    - Spring Data JPA
- **H2 Database** (In-Memory)
- **Lombok**
- **Maven**

---

## 📐 Arquitetura e Design Patterns

A aplicação adota uma arquitetura em camadas bem definida e desacoplada:

1. **Domain (`domain`)**: Contém os modelos de domínio (`Offer`, `CustomerContext`, `OfferType`) e a interface/implementações do padrão **Strategy** (`OfferStrategy`, `CreditOfferStrategy`, `InsuranceOfferStrategy`, `CashbackOfferStrategy`).
2. **Application (`application`)**: Serviço responsável por orquestrar a execução das estratégias elegíveis e persistência.
3. **Infrastructure (`infrastructure`)**: Camada de persistência e repositórios.
4. **API (`api`)**: Controllers REST, DTOs de entrada e saída e tratamento global de exceções.

### Padrão Strategy
O padrão **Strategy** foi implementado para permitir a extensão do motor de ofertas sem modificar o código existente (Princípio Open/Closed do SOLID). O Spring injeta automaticamente todas as implementações da interface `OfferStrategy`, e o serviço itera sobre elas verificando a elegibilidade do cliente através do método `isApplicable()`.

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos
- JDK 21 instalado e configurado nas variáveis de ambiente.
- Maven (opcional, pode-se usar o `./mvnw` do próprio projeto).

### Passos para execução
1. Clone o repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/offer-strategy-api.git](https://github.com/SEU_USUARIO/offer-strategy-api.git)
   cd offer-strategy-api
   
2. Compilar e rodar a aplicação via Maven Wrapper:
   ````bash
   # Windows
    .\mvnw spring-boot:run

    # Linux/Mac
    ./mvnw spring-boot:run

3. A aplicação estará acessível em http://localhost:8080.

🧪 Testando a API (Exemplo cURL)
Você pode testar a API utilizando o comando curl abaixo diretamente no terminal ou importando no Insomnia/Postman:

Requisição POST /api/offers/evaluate

        curl --location 'http://localhost:8080/api/offers/evaluate' \
        --header 'Content-Type: application/json' \
        --data '{
        "customerId": "cust-123",
        "monthlyIncome": 5000.00,
        "creditScore": 750,
        "hasAccount": true
        }'

Resposta Esperada (200 OK)
```bash
    [
      {
        "id": "e8d7f4a2-8b3c-4a1d-9e2f-1a2b3c4d5e6f",
        "customerId": "cust-123",
        "type": "CREDIT",
        "description": "Pré-aprovação de Cartão de Crédito com Limite Especial",
        "value": 12500.00
      },
      {
        "id": "a1b2c3d4-e5f6-7a8b-9c0d-1e2f3a4b5c6d",
        "customerId": "cust-123",
        "type": "INSURANCE",
        "description": "Seguro de Vida com Desconto para Correntistas",
        "value": 50.00
      },
      {
        "id": "f9e8d7c6-b5a4-3f2e-1d0c-9b8a7f6e5d4c",
        "customerId": "cust-123",
        "type": "CASHBACK",
        "description": "Programa de Cashback de 2% em todas as compras",
        "value": 20.00
      }
    ]
