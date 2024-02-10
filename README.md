# Mini Autorizador de Transações 💳

O Mini Autorizador de Transações é uma aplicação desenvolvida em Java com o framework Spring que realiza validações com base em regras de autorização para transações financeiras. 
Além disso, o sistema envia e-mails de notificação informando sobre o status das transações aprovadas.

## 🛠 Tecnologias Utilizadas:

- Java
- Spring Boot
- JavaMail
- Spring Web
- Spring Validation
- Log4j2
- Spring Data JPA
- Maven
- Lombok
- FreeMarker
- Flyway (organizar os scripts SQL que são executados no banco de dados, controlando as versões do mesmo.)
- Docker Compose (para criação e gerenciamento do banco de dados MySQL)

## Funcionalidades Principais:

Validação de transações com base em regras de autorização.
Envio de e-mails de notificação para transações aprovadas. 
Utilizado padrão Domain Events do DDD para disparar um evento quando a transação for aprovada.
Configuração e Implantação:
O projeto utiliza Docker Compose para facilitar a configuração e implantação do banco de dados MySQL. 

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas: Git, JDK 17, Maven,
Docker e Docker Compose. Além disso, é recomendável ter um editor para trabalhar com o código como IntelliJ IDEA.

## 🎲 Rodando o projeto

Após clonar o repositório, basta executar o Docker Compose para iniciar o banco de dados.
Em seguida, a aplicação Spring pode ser executada localmente, pois está utilizando um servidor Tomcat embutido
rodando na porta 8080. Não é necessário a instalação do Tomcat.
