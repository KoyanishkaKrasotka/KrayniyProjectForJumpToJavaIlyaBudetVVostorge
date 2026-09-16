package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class SimilarFilmResponse {

    private Integer total;

    private List<SimilarFilmItem> items;

    public SimilarFilmResponse() {
    }

    public SimilarFilmResponse(Integer total, List<SimilarFilmItem> items) {
        this.total = total;
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<SimilarFilmItem> getItems() {
        return items;
    }

    public void setItems(List<SimilarFilmItem> items) {
        this.items = items;
    }
}
