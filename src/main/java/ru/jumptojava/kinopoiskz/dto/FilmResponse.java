package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class FilmResponse {

    private Integer total;

    private Integer totalPages;

    private List<FilmItem> items;

    public FilmResponse() {
    }

    public FilmResponse(Integer total, Integer totalPages, List<FilmItem> items) {
        this.total = total;
        this.totalPages = totalPages;
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<FilmItem> getItems() {
        return items;
    }

    public void setItems(List<FilmItem> items) {
        this.items = items;
    }
}
