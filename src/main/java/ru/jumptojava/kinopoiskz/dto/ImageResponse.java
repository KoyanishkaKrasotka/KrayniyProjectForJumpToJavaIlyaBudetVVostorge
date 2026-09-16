package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class ImageResponse {

    private Integer total;

    private Integer totalPages;

    private List<ImageDto> items;

    public ImageResponse() {
    }

    public ImageResponse(Integer total, Integer totalPages, List<ImageDto> items) {
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

    public List<ImageDto> getItems() {
        return items;
    }

    public void setItems(List<ImageDto> items) {
        this.items = items;
    }
}
