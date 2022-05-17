# Projeto Wallet


## Instalação

Clonar o projeto, importar e configurar a JDK 11 na IDE de preferência
Rodar o maven install no projeto librabbitmq


## Endpoints

```java

#Serviço: cadastro
/usuario/cadastrar - Cadastra um novo usuário na base de dados

#Serviço: extrato
/extrato/saldo - Consulta o saldo de uma conta
/extrato/movimentacao - consulta o histórico de movimentação de uma conta
/extrato/criarConta - Cria uma conta após um novo usuário ser cadastrado
/transacao/debitar - realiza o debito do saldo de uma conta
/transacao/creditar - Realiza o crédito no saldo de uma conta

#Serviço: transferencia
/transferencia/transferir - Realiza transferência entre 2 contas

#Serviço: pagamentos
/pagamentos/pagar - Realiza o pagamento de uma conta

OBS: Para utilizar o serviço de pagamentos e a url /pagamentos/pagar é necessário rodar o comando "docker-compose up" na raiz do projeto, pois a funcionalidade de pagamento foi construida utilizando RabbitMQ


```



Collections disponível no projeto, arquivo com nome "Wallet.postman_collection.json"

Não foram finalizados os testes unitários e o projeto não foi totalmente dockerizado.
