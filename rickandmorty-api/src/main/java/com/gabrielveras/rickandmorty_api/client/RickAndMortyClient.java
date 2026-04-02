package com.gabrielveras.rickandmorty_api.client;

import com.gabrielveras.rickandmorty_api.dto.ApiResponseDTO;
import com.gabrielveras.rickandmorty_api.dto.PersonagemDTO;
import com.gabrielveras.rickandmorty_api.dto.LocalDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

// Responsavel por consumir diretamente a API externa do Rick and Morty.
// Usa RestClient
// @Cacheable evita chamadas repetidas a API armazenando o resultado em cache.
@Component
public class RickAndMortyClient {

    private final RestClient restClient;

    // Injeta a URL base definida no application.properties
    public RickAndMortyClient(@Value("${rickandmorty.api.base-url}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    // Cache "personagens" — armazena resultado por pagina
    @Cacheable(value = "personagens", key = "#page")
    public ApiResponseDTO<PersonagemDTO> listarPersonagens(int page) {
        return restClient.get()
                .uri("/character?page=" + page)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    // Cache "personagem-nome" — armazena resultado por nome buscado
    @Cacheable(value = "personagem-nome", key = "#nome")
    public ApiResponseDTO<PersonagemDTO> buscarPorNome(String nome) {
        return restClient.get()
                .uri("/character?name=" + nome)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    // Cache "personagem-status" — armazena resultado por status
    @Cacheable(value = "personagem-status", key = "#status + '-' + #page")
    public ApiResponseDTO<PersonagemDTO> filtrarPorStatus(String status, int page) {
        return restClient.get()
                .uri("/character?status=" + status + "&page=" + page)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    // Cache "personagem-id" — armazena cada personagem por ID
    @Cacheable(value = "personagem-id", key = "#id")
    public PersonagemDTO buscarPorId(int id) {
        return restClient.get()
                .uri("/character/" + id)
                .retrieve()
                .body(PersonagemDTO.class);
    }

    // Cache "locais" — armazena resultado por pagina
    @Cacheable(value = "locais", key = "#page")
    public ApiResponseDTO<LocalDTO> listarLocais(int page) {
        return restClient.get()
                .uri("/location?page=" + page)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    // Cache "local-id" — armazena cada local por ID
    @Cacheable(value = "local-id", key = "#id")
    public LocalDTO buscarLocalPorId(int id) {
        return restClient.get()
                .uri("/location/" + id)
                .retrieve()
                .body(LocalDTO.class);
    }
}