# Agenda Vet - Server

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/felipesousac/agenda-vet/blob/main/LICENSE)

# Sobre o projeto

API REST que permite o gerenciamento de administradores de um sistema veterinário. Como tratam-se de dados sensíveis e de acesso restrito, as requisições são liberadas por meio de autenticações.

# Endpoints

### authentication-controller

<code>POST</code> <code>/adminLogin</code> - valida os dados de login enviados no corpo da requisição, e se válidos, a requisição retorna um token de autenticação que é enviado em cada requisição do admin-controller.

### admin-controller

<code>GET</code> <code>/admin</code> - lista todos os administradores cadastrados no banco de dados

<code>PUT</code> <code>/admin</code> - atualiza os dados de um administrador com base em seu ID

<code>POST</code> <code>/admin</code> - cria um novo administrador no banco de dados de acordo com o corpo da requisição enviado

<code>POST</code> <code>/admin/{id}</code> - lista o administrador referente ao id enviado no path

<code>DELETE</code> <code>/admin/{id}</code> - apaga o administrador referente ao id enviado no path

# Tecnologias utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- MySQL
- Flyway
- Spring Security
- Auth0 / JWT
- Maven

# Como executar o projeto

## Back end

Pré-requisitos: Java 19

```bash
# clonar repositório
git clone git@github.com:felipesousac/agenda-vet.git

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```

## Documentação

```bash
# após executar o projeto, acessar a url abaixo
http://localhost:8080/swagger-ui/index.html#/
```
