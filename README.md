# Ambiente Teste API

![Java](https://img.shields.io/badge/Java-25-orange)
![OpenJDK](https://img.shields.io/badge/OpenJDK-25-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Build](https://img.shields.io/badge/Build-passing-brightgreen)

Projeto de estudo para criação, teste e validação de endpoints REST com Spring Boot,
Swagger/OpenAPI e persistência em PostgreSQL.

O objetivo deste repositório é disponibilizar uma base limpa, organizada e
evolutiva para praticar o desenvolvimento de APIs seguindo boas práticas de
mercado, com foco em separação de responsabilidades, padronização de respostas,
documentação automática e integração com banco de dados SQL.

Este projeto foi preparado para receber, ao longo dos estudos, novas entidades,
models de entrada e saída, mappers, specifications, services, repositories e
controllers versionados.

## Sobre O Projeto

A proposta da `Ambiente Teste API` é funcionar como um ambiente local para
experimentar e validar endpoints de forma organizada. Cada novo recurso criado
poderá ser documentado automaticamente no Swagger, persistido no PostgreSQL e
estruturado em camadas bem definidas.

O fluxo esperado para os próximos endpoints é:

```text
Request -> Controller -> Service -> Repository -> PostgreSQL
Response <- Mapper <- Entity
```

Com essa organização, os controllers ficam responsáveis apenas pelo contrato
HTTP, os services concentram as regras de negócio, os repositories cuidam da
persistência e os mappers fazem a conversão entre entidades e models da API.

## Tecnologias

- Java 25 com OpenJDK
- Spring Boot 3.5.5
- Spring Web
- Spring Data JPA
- Bean Validation
- PostgreSQL 17
- Springdoc OpenAPI/Swagger
- MapStruct
- Lombok
- Maven
- Spotless com Google Java Format

## Arquitetura De Pastas

```text
src/main/java/br/com/estudos/ambienteteste
├── config
├── controller
├── domain
│   ├── entity
│   └── enums
├── exception
├── mapper
├── models
├── repository
├── service
└── specification
```

## Responsabilidades

- `config`: configurações da aplicação, como Swagger/OpenAPI.
- `controller`: endpoints REST versionados em `/api/v1`.
- `domain`: entidades JPA e conceitos centrais do domínio.
- `exception`: exceções customizadas e tratamento global de erros.
- `mapper`: conversões entre entidades e models.
- `models`: modelos de entrada e saída da API, incluindo Requests (VOs) e Responses (DTOs).
- `repository`: acesso a dados com Spring Data JPA.
- `service`: regras de negócio e orquestração dos casos de uso.
- `specification`: filtros dinâmicos e consultas reutilizáveis.

## Padrão De Models

A pasta `models` será utilizada para concentrar os contratos de entrada e saída
da API. A ideia é manter os models próximos do contexto dos endpoints, evitando
expor entidades JPA diretamente nas requisições e respostas.

Padrão sugerido:

- `AlgumRecursoRequest`: model de entrada da API, usado como VO para representar dados recebidos em criação, atualização ou filtros.
- `AlgumRecursoResponse`: model de saída da API, usado como DTO para representar os dados retornados ao cliente.
- `AlgumRecursoFilterRequest`: model opcional para filtros de consulta, quando houver uso de `specification`.

Exemplo de evolução futura:

```text
models
├── ProdutoRequest.java
├── ProdutoResponse.java
└── ProdutoFilterRequest.java
```

Esse padrão ajuda a manter a API mais segura e organizada, porque as entidades
do banco permanecem no domínio enquanto os models representam apenas o contrato
exposto pelos endpoints.

## Banco De Dados

Este projeto espera um PostgreSQL local já criado com o banco:

```text
ambiente-teste
```

Configuração padrão:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ambiente-teste
spring.datasource.username=postgres
spring.datasource.password=123456
```

Também é possível sobrescrever os valores por variáveis de ambiente:

```text
SQL_DB_HOST
SQL_DB_PORT
SQL_DB_NAME
SQL_DB_USER
SQL_DB_PASSWORD
```

## Como Executar

Pré-requisitos:

- OpenJDK 25
- Maven
- PostgreSQL 17 com o banco `ambiente-teste` criado

Execute a aplicação:

```bash
mvn spring-boot:run
```

Swagger UI:

```text
http://localhost:8080/api/v1/swagger-ui.html
```

Health check:

```text
http://localhost:8080/api/v1/health
```

## Qualidade

Compilar o projeto:

```bash
mvn -DskipTests package
```

Validar formatação:

```bash
mvn spotless:check
```

## Tratamento De Exceções

A API utiliza `ResponseEntity` e `HttpStatus` nativos do Spring para retornar
códigos HTTP de forma clara, sem criação manual de enums ou constantes de status.

Principais códigos previstos:

- `200 OK`
- `201 CREATED`
- `204 NO CONTENT`
- `400 BAD REQUEST`
- `401 UNAUTHORIZED`
- `403 FORBIDDEN`
- `404 NOT FOUND`
- `409 CONFLICT`
- `422 UNPROCESSABLE ENTITY`
- `500 INTERNAL SERVER ERROR`

O tratamento de erros é centralizado com `@RestControllerAdvice`, mantendo as
respostas consistentes em todos os endpoints.

Estrutura do pacote `exception`:

- `BusinessException`
- `ErrorResponse`
- `GlobalExceptionHandler`
- `ResourceNotFoundException`
- `ValidationException`

Modelo padrão de erro:

```json
{
  "status": 404,
  "error": "NOT_FOUND",
  "message": "Cliente não encontrado",
  "timestamp": "2026-05-13T20:00:00",
  "path": "/api/v1/clientes/1"
}
```

As respostas da API devem ser documentadas com Swagger/Springdoc usando
`@ApiResponse`, informando explicitamente os possíveis códigos HTTP de cada
endpoint.

## Próximos Passos

- Criar as primeiras entidades em `domain/entity`.
- Criar models de `Request` (VO) e `Response` (DTO) em `models`.
- Criar mappers com MapStruct em `mapper`.
- Criar repositories com Spring Data JPA em `repository`.
- Criar services com regras de negócio em `service`.
- Criar filtros reutilizáveis em `specification`.
- Criar novos controllers versionados em `/api/v1`.

## Licença

Este projeto está licenciado sob a licença MIT.
