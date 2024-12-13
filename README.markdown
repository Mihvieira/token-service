# Aplicação Java Spring para Login de Usuários e geração de Tokens - em andamento

## Descrição
Esta aplicação Java, desenvolvida com o framework Spring Boot, oferece funcionalidades básicas para gerenciar usuários, incluindo criação, autenticação e geração de tokens de acesso. A aplicação utiliza o banco de dados MySQL para armazenar as informações dos usuários e o Spring Data JPA para interagir com o banco de dados.

Esse projeto teve como ponto de partida o desafio [Addison Global Backend Technical Assesement](https://github.com/addisonglobal/backend-technical-test) e foi sendo adaptado para incluir outras funcionalidades.

## Funcionalidades Principais:

* Criação de usuários: Permite criar novos usuários com nome de usuário e senha.
* Autenticação: Valida as credenciais do usuário durante o login.
* Geração de tokens: Gera tokens de acesso JWT (JSON Web Token) para usuários autenticados. (a implementar)
* Camadas bem definidas: A aplicação segue a arquitetura MVC, com camadas Controller, Service, Repository e Entities, promovendo a organização do código e a separação de responsabilidades.
* Banco de dados MySQL: Utiliza o MySQL como banco de dados para armazenar as informações dos usuários.

## Tecnologias Utilizadas:
* Java: Linguagem de programação.
* Spring Boot: Framework Java para desenvolvimento de aplicações.
* Spring Data JPA: Framework para acesso a dados.
* Spring Security (a implementar)
* MySQL: Banco de dados relacional.
* JWT: JSON Web Token para autenticação. (a implementar)

## Estrutura do projeto

```
projeto
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.tokenserviceapp
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── repository
│   │   │       └── entities
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com.example
├── pom.xml
```

* controller: Contém os controladores REST para as requisições HTTP.
* service: Contém a lógica de negócio da aplicação.
* repository: Contém as interfaces dos repositórios para interagir com o banco de dados.
* entities: Contém as classes que representam as entidades do domínio.
* application.properties: Arquivo de configuração da aplicação.

## Pré-requisitos:
* Java Development Kit (JDK): Instalar o JDK compatível com o projeto.
* Maven: Ferramenta de build para gerenciar as dependências do projeto.
* MySQL: Instalar e configurar o banco de dados MySQL.

## Como Executar:
1. Clonar o repositório:
```
git clone https://github.com/Mihvieira/token-service.git
```

2. Importar o projeto: Importar o projeto no seu IDE favorito (Eclipse, IntelliJ, etc.).
3. Configurar o banco de dados: Criar um banco de dados MySQL e configurar as credenciais no arquivo application.properties.
4. Executar a aplicação: Utilizar a ferramenta de build (Maven) para executar a aplicação.

## Como Utilizar:
* Criar um usuário: Enviar uma requisição POST para a URL /login/new-user com os dados do usuário e senha no corpo da requisição.Exemplo:
```
{
    "username": "username",
    "password": "senha"
}
```
* Autenticar um usuário: Enviar uma requisição POST para a URL /login com as credenciais do usuário no corpo da requisição.
* Obter informações do usuário: Enviar uma requisição GET para a URL /usuarios/{username} com o nome do usuário.

## Futuras implementações

* Segurança: Implementar medidas de segurança adicionais, como criptografia de senhas e validação de dados de entrada.

* Testes: Implementar testes unitários e de integração para garantir a qualidade do código.
