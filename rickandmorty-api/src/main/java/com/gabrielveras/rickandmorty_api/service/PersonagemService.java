package com.gabrielveras.rickandmorty_api.service;

import com.gabrielveras.rickandmorty_api.client.RickAndMortyClient;
import com.gabrielveras.rickandmorty_api.dto.ApiResponseDTO;
import com.gabrielveras.rickandmorty_api.dto.PersonagemDTO;
import org.springframework.stereotype.Service;

// Camada de servico: orquestra as chamadas ao client
// e pode aplicar regras de negócio sobre os dados recebidos.
@Service
public class PersonagemService {

    private final RickAndMortyClient client;

    public PersonagemService(RickAndMortyClient client) {
        this.client = client;
    }

    public ApiResponseDTO<PersonagemDTO> listarPersonagens(int page) {
        return client.listarPersonagens(page);
    }

    public PersonagemDTO buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero");
        }
        return client.buscarPorId(id);
    }

    public ApiResponseDTO<PersonagemDTO> buscarPorNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome nao pode ser vazio");
        }
        return client.buscarPorNome(nome.trim());
    }

    public ApiResponseDTO<PersonagemDTO> filtrarPorStatus(String status, int page) {
        // Valida se o status e um dos valores aceitos pela API
        if (!status.equalsIgnoreCase("alive")
                && !status.equalsIgnoreCase("dead")
                && !status.equalsIgnoreCase("unknown")) {
            throw new IllegalArgumentException(
                    "Status invalido. Use: alive, dead ou unknown");
        }
        return client.filtrarPorStatus(status, page);
    }
}