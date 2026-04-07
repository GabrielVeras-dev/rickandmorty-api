# 🛸 Rick and Morty API

API REST desenvolvida com **Java + Spring Boot** que consome a [Rick and
Morty API](https://rickandmortyapi.com) e expõe endpoints próprios com
**cache, paginação e filtros**.

![Java](https://img.shields.io/badge/Java-21-orange) ![Spring
Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-green)
![Docker](https://img.shields.io/badge/Deploy-Docker-blue) ![Oracle
Cloud](https://img.shields.io/badge/Hospedagem-Oracle%20Cloud-red)

------------------------------------------------------------------------

## 🚀 Deploy

👉 **API em produção**\
https://gabrielveras-api.duckdns.org/api/personagens

📄 **Documentação Swagger**\
https://gabrielveras-api.duckdns.org/swagger-ui/index.html

🖥️ **Frontend**\
https://devgabrielveras-apirickandmorty.vercel.app

------------------------------------------------------------------------

## 🛠️ Tecnologias

-   Java 21
-   Spring Boot 4.0.3
-   RestClient (Spring 6.1)
-   Spring Cache + Caffeine
-   Swagger / OpenAPI
-   JUnit 5 + Mockito
-   Docker
-   Nginx + Let's Encrypt (SSL)
-   Oracle Cloud Free Tier
-   DuckDNS

------------------------------------------------------------------------

## 📋 Endpoints

  -----------------------------------------------------------------------------------------------
Método              Endpoint                                         Descrição
  ------------------- ------------------------------------------------ --------------------------
GET                 `/api/personagens?page=1`                        Lista paginada de
personagens

GET                 `/api/personagens/{id}`                          Busca personagem por ID

GET                 `/api/personagens/buscar?nome=Rick`              Busca personagem por nome

GET                 `/api/personagens/filtrar?status=alive&page=1`   Filtra por status

GET                 `/api/locais?page=1`                             Lista paginada de locais

GET                 `/api/locais/{id}`                               Busca local por ID
-----------------------------------------------------------------------------------------------

------------------------------------------------------------------------

## 🔗 Exemplos de requisição (Produção)

### 📌 Listar personagens

``` http
GET https://gabrielveras-api.duckdns.org/api/personagens
```

### 📌 Buscar personagem por ID

``` http
GET https://gabrielveras-api.duckdns.org/api/personagens/1
```

### 📌 Buscar personagem por nome

``` http
GET https://gabrielveras-api.duckdns.org/api/personagens/buscar?nome=Rick
```

### 📌 Filtrar personagens por status

``` http
GET https://gabrielveras-api.duckdns.org/api/personagens/filtrar?status=alive
```

### 📌 Listar locais

``` http
GET https://gabrielveras-api.duckdns.org/api/locais
```

### 📌 Buscar local por ID

``` http
GET https://gabrielveras-api.duckdns.org/api/locais/1
```

------------------------------------------------------------------------

## ☁️ Infraestrutura

O backend roda em **container Docker** na **Oracle Cloud Free Tier**,
utilizando:

-   **Nginx** como proxy reverso
-   **Let's Encrypt** para certificado SSL gratuito
-   **DuckDNS** para domínio gratuito
-   **Docker** com restart automático em caso de falha

------------------------------------------------------------------------

## ⚙️ Executando localmente

``` bash
git clone https://github.com/GabrielVeras-dev/rickandmorty-api.git
cd rickandmorty-api/rickandmorty-api
mvn spring-boot:run
```

### 🔎 Acessos locais

API:

    http://localhost:8080/api/personagens

Swagger:

    http://localhost:8080/swagger-ui/index.html

------------------------------------------------------------------------

## 👨‍💻 Autor

**Gabriel Veras**\
Desenvolvedor Java | Spring Boot | APIs REST
