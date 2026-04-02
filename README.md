# 🛸 Rick and Morty API

API REST desenvolvida com Java e Spring Boot que consome a [Rick and Morty API](https://rickandmortyapi.com) e expõe endpoints próprios com cache, paginação e filtros.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-green)
![Railway](https://img.shields.io/badge/Deploy-Railway-purple)

## 🚀 Deploy

👉 **[API em produção](https://rickandmorty-api-production.up.railway.app/api/personagens)**

📄 **[Documentação Swagger](https://rickandmorty-api-production.up.railway.app/swagger-ui/index.html)**

## 🛠️ Tecnologias

- Java 21
- Spring Boot 4.0.3
- RestClient
- Spring Cache + Caffeine
- Swagger/OpenAPI
- JUnit + Mockito
- Deploy no Railway

## 📋 Endpoints

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/api/personagens?page=1` | Lista paginada de personagens |
| GET | `/api/personagens/{id}` | Busca personagem por ID |
| GET | `/api/personagens/buscar?nome=Rick` | Busca personagem por nome |
| GET | `/api/personagens/filtrar?status=alive&page=1` | Filtra por status (alive/dead/unknown) |
| GET | `/api/locais?page=1` | Lista paginada de locais |
| GET | `/api/locais/{id}` | Busca local por ID |

## 🔗 Exemplos em produção
```
GET https://rickandmorty-api-production.up.railway.app/api/personagens
GET https://rickandmorty-api-production.up.railway.app/api/personagens/1
GET https://rickandmorty-api-production.up.railway.app/api/personagens/buscar?nome=Rick
GET https://rickandmorty-api-production.up.railway.app/api/personagens/filtrar?status=alive
GET https://rickandmorty-api-production.up.railway.app/api/locais
GET https://rickandmorty-api-production.up.railway.app/api/locais/1
```

## ⚙️ Como executar localmente
```bash
git clone https://github.com/GabrielVeras-dev/rickandmorty-api.git
cd rickandmorty-api
mvn spring-boot:run
```

Acesse: `http://localhost:8080/api/personagens`

Swagger: `http://localhost:8080/swagger-ui/index.html`
