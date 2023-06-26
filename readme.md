# Repositório - Desafio técnico FADESP

## Dependências:
* Spring Boot Starter Web

* Spring Boot Start Test

* H2 Database

* Lombok

* ModelMapper


# Tecnologias
* Spring Boot 3.1.1

* Java 17

# Teste

* Postman 10.15

# Testando a API

* CREATE (POST) - localhost:8080/pagamento  

```
{
    "codigoDebito": "1234", 

    "cpfCnpjPagador" : "12345678910",

    "metodoPagamento": "CARTAO",

    "numeroCartao" : "123456",

    "valor" : "100"    
}
```

* READ (GET) - localhost:8080/pagamento
```
{
    "id": 1,
    "codigoDebito": 1234,
    "cpfCnpjPagador": "12345678910",
    "metodoPagamento": "PIX",    
    "valor": 100,
    "status": "PENDENTE_PROCESSAMENTO"
}

{
    "id": 2,
    "codigoDebito": 123456,
    "cpfCnpjPagador": "12345678999",
    "metodoPagamento": "PIX",    ,
    "valor": 50,
    "status": "PENDENTE_PROCESSAMENTO"
}
```

* READ (GET) - localhost:8080/pagamento/id
```
{
    "id": 1,
    "codigoDebito": 1234,
    "cpfCnpjPagador": "12345678910",
    "metodoPagamento": "PIX",    
    "valor": 100,
    "status": "PENDENTE_PROCESSAMENTO"
}
```
* READ (GET) - localhost:8080/pagamento/cpf/12345678910

```
{
    "id": 1,
    "codigoDebito": 1234,
    "cpfCnpjPagador": "12345678910",
    "metodoPagamento": "PIX",    
    "valor": 100,
    "status": "PENDENTE_PROCESSAMENTO"
}
```
* READ (GET) - localhost:8080/pagamento/codigo/123456000

```
{
    "id": 1,
    "codigoDebito": 1234,
    "cpfCnpjPagador": "12345678910",
    "metodoPagamento": "PIX",    
    "valor": 100,
    "status": "PENDENTE_PROCESSAMENTO"
}
```
* UPDATE (PUT) - localhost:8080/pagamento/id
```
{
    "id": 1,
    "codigoDebito": 1234,
    "cpfCnpjPagador": "12345678910",
    "metodoPagamento": "BOLETO", 
    "valor": 100,
    "status": "PENDENTE_PROCESSAMENTO"
}

{
    "id": 1,
    "codigoDebito": 1234,
    "cpfCnpjPagador": "12345678910",
    "metodoPagamento": "PIX", 
    "valor": 100,
    "status": "PENDENTE_PROCESSAMENTO"
}
```
* DELETE (DEL) - localhost:8080/pagamento/id
```
[]
```



