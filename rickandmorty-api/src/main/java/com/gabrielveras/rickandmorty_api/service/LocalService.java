package com.gabrielveras.rickandmorty_api.service;

import com.gabrielveras.rickandmorty_api.client.RickAndMortyClient;
import com.gabrielveras.rickandmorty_api.dto.ApiResponseDTO;
import com.gabrielveras.rickandmorty_api.dto.LocalDTO;
import org.springframework.stereotype.Service;

@Service
public class LocalService {

    private final RickAndMortyClient client;

    public LocalService(RickAndMortyClient client) {
        this.client = client;
    }

    public ApiResponseDTO<LocalDTO> listarLocais(int page) {
        return client.listarLocais(page);
    }

    public LocalDTO buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero");
        }
        return client.buscarLocalPorId(id);
    }
}