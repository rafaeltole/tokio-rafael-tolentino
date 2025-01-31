## Tokio :: Rafael Tolentino

Projeto para avaliação prática Tokio.

### Objetivo
Desenvolver uma aplicação (front-end e back-end) utilizando Java, Spring Boot e Angular. 

### Descrição dos passos para análise e desenvolvimento
Projeto desenvolvido em Java 11, utilizando como base o Spring Boot 2.6.15 (_última versão 
com suporte ao Java 11_) e banco de dados H2 em memória.

O requisito do projeto é realizar o agendamento de transferências financeiras. Um dos primeiro passos foi analisar
o domínio da aplicação, composto pelas classes: Agendamento, Taxa e Conta. Feito isso, a regra de
negócio para o cálculo do valor da taxa, que corresponde a uma tabela com o intervalo de dias para realizar
a transferência, valor fixo e percentual, implementei na classe Taxa, que na minha opinião, é a responsável
por manter essa lógica e com isso simplificou a escrita dos testes para validação das regras.

Sobre a estrutura do projeto, procurei seguir o padrão MVC, organizando as classes nos pacotes:
* **model**, com as entidades, alguns DTOs e classes de acesso ao dados;
* **service**, classe para controlar a regra de negócio; 
* **controller**, classe responsável pela integração com o front-end;
* **utils**, que são as classes utilitárias com funções comuns ao projeto

Na integração com o front-end, optei por utilizar DTO para a transferência dos dados com as anotações para 
validação e um "transformador" para facilar a conversão entre DTO e Entidade.

O gerenciamento das dependências e empacotamento da aplicação optei pelo Maven, por ser um dos mais utilizados, mas 
ainda será necessário a tarefa manual para copiar os arquivos utilizados pelo front-end para o diretório static.

### Configuração do ambiente
Para compilar e executar a aplicação será necessário instalar:

* [Git](https://git-scm.com/downloads)
* [Java - 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Node - v22.13.1](https://nodejs.org/en/download)

1. Baixar os fontes do projeto

```
git clone https://github.com/rafaeltole/tokio-rafael-tolentino.git
```
_obs.: daqui para frente vamos nos referenciar ao diretório base do projeto como: **${project.basedir}**_

2. Compilar o front-end (Angular)
   1. navegar até o diretório: _${project.basedir}/src/main/webapp/_
   2. executar os comandos:
        ```
        npm install @angular/cli
        
        ng build --configuration production --base-href /tokio-rafael-tolentino/
        ```
      3. copiar os arquivos que foram em:
         4. _${project.basedir}/src/main/webapp/dist/webapp/browser/_    
      5. para:
         6. _${project.basedir}/src/main/resources/static/_


3. Compilar o projeto utilizando o Maven. Retorne ao diretório base do projeto (_${project.basedir}_) e execute o comando:
    ```
    mvn clean package
    ```

4. Inicializando a aplicação. Execute o comando:
    ```
    java -jar target/tokio-rafael-tolentino.jar
    ```
 
5. Abra o seu navegador e acesse a URL: http://localhost:8080/tokio-rafael-tolentino
