package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class CollectionResponse {

    private Integer total;

    private Integer totalPages;

    private List<CollectionFilmsDto> items;

    public CollectionResponse() {
    }

    public CollectionResponse(Integer total, Integer totalPages, List<CollectionFilmsDto> items) {
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

    public List<CollectionFilmsDto> getItems() {
        return items;
    }

    public void setItems(List<CollectionFilmsDto> items) {
        this.items = items;
    }
}
