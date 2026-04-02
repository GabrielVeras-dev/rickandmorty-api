package com.gabrielveras.rickandmorty_api.dto;

import java.util.List;

// Representa um local/planeta da API do Rick and Morty
public class LocalDTO {

    private int id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private String created;

    public LocalDTO() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDimension() { return dimension; }
    public void setDimension(String dimension) { this.dimension = dimension; }

    public List<String> getResidents() { return residents; }
    public void setResidents(List<String> residents) { this.residents = residents; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }
}