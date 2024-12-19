# Microservice Personal Credit

## Description

Microservice for registering and consulting clients, checking eligible and applying credit modalities for individuals according to specific criteria.

---

## Technology Stack

The project leverages the following technologies:

- **Java 21**
- **Spring Boot 3**
- **PostgresDB**
- **Flyway**
- **Docker**
- **Jacoco**

---

## Swagger Documentation

The API documentation for this microservice is available at the following path:

- Swagger UI: /openapi

This provides an interactive interface for exploring and testing the API endpoints.

---

## Getting Started

### Prerequisites

- Docker installed on your machine.

### Running the Application

1. **Start Dependencies with Docker**  
   Navigate to the `/helper/docker` directory and run:
   ```
   docker-compose up
   ```

2. **Start the Application**

   Run the following command to start the Spring Boot application:
   ```shell
   ./mvnw spring-boot:run
   ```

## Build and Test

### Build the Application

```shell
  ./mvnw clean install
```

## Run Unit Tests

```shell
  ./mvnw test
```

## Generate Test Coverage Report

```shell
  ./mvnw clean verify
```

## View Test Coverage

After running, you can find the test coverage report in the target/site/jacoco/index.html file.
Open this file in a browser to view the detailed test coverage metrics.

--- 

---

# Avaliação para admissão de Desenvolvedores para a Neurotech

## Instruções

- Realize o fork deste projeto para desenvolver a sua solução. Não serão aceitos commits diretamente para este repositório;
- Após o desenvolvimento da sua solução, nos avise, enviando o link do seu projeto para que iniciemos a avaliação. **Não crie Pull Requests!**
- A solução deve ser entregue em um prazo máximo de 3 dias. 

## Descrição

Trata-se de um projeto que avalia e aplica modalidades diferentes de crédito a clientes PF, de acordo com critérios específicos. As modalidades diferentes de crédito estão descritas a seguir:

-   Crédito com Juros fixos: Aplicado a clientes com idade entre 18 e 25 anos, independente de renda. Taxa de 5% a.a
-   Crédito com Juros variáveis: Aplicado a clientes com idade entre 21 e 65 anos, com renda entre R$ 5000,00 e R$ 15000,00.
-   Crédito Consignado: Aplicado a clientes acima de 65 anos, independente de renda.

O projeto deve ser implantado como uma API RESTful, utilizando a linguagem Java e o framework Springboot. Atentar para implementações típicas de uma API RESTful, como códigos HTTP para cada tipo de endpoint, validação de dados, Documentação utilizando Swagger, e também testes automáticos para os endpoints implementados.

De maneira obrigatória, os seguintes endpoints devem ser implementados:

-   Endpoint para cadastro de clientes: Deve receber Informações como Nome, idade, renda. Como retorno, uma entrada no header da resposta contendo a URL que identifica o cliente (Ex: [http://localhost/api/client/050](http://localhost/api/client/050)). O nome do header deve ser “Location”.
    
-   Endpoint para retornar os dados do cliente de acordo com seu ID, indicado na URL (Ex: [http://localhost/api/client/050](http://localhost/api/client/050)). O retorno deve ser um objeto JSON contendo os dados do cliente. Por exemplo:

```
{ 
  "Name": "Bob",
  "Age": 40,
  "Income": 10000
}
```
-   Endpoint para definir se um determinado cliente está apto a oferecer um crédito automotivo para determinado modelo de veículo.
    -   Hatch: Renda entre R$ 5000,00 e R$15000,00.
    -   SUV: Renda acima de R$8000,00 e idade superior a 20 anos.
    

Como adicional, mas não obrigatório, implemente um endpoint para se determinar todos os clientes entre 23 e 49 anos que possuem Crédito com juros fixos e estão aptos a adquirirem crédito automotivo para veículos do tipo Hatch. O objeto de retorno deve conter uma lista com o nome e a renda de cada um destes clientes.

Boa sorte!
