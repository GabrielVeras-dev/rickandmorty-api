package com.gabrielveras.rickandmorty_api.dto;

import java.util.List;

// Wrapper generico que representa qualquer resposta paginada da API
// T pode ser PersonagemDTO, LocalDTO, etc.
public class ApiResponseDTO<T> {

    private InfoDTO info;
    private List<T> results;

    public ApiResponseDTO() {}

    public InfoDTO getInfo() { return info; }
    public void setInfo(InfoDTO info) { this.info = info; }

    public List<T> getResults() { return results; }
    public void setResults(List<T> results) { this.results = results; }
}