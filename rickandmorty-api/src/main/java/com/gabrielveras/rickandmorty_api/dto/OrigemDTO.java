package com.gabrielveras.rickandmorty_api.dto;

// Representa a origem/localizacao de um personagem
public class OrigemDTO {

    private String name;
    private String url;

    public OrigemDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}