package com.gabrielveras.rickandmorty_api.dto;

// Representa as informacoes de paginacao retornadas pela API
public class InfoDTO {

    private int count;   // total de registros
    private int pages;   // total de paginas
    private String next; // URL da proxima pagina
    private String prev; // URL da pagina anterior (prev = previous)

    public InfoDTO() {}

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public String getNext() { return next; }
    public void setNext(String next) { this.next = next; }

    public String getPrev() { return prev; }
    public void setPrev(String prev) { this.prev = prev; }
}