package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class SeasonsResponse {

    private Integer total;

    private List<SeasonDto> items;

    public SeasonsResponse() {
    }

    public SeasonsResponse(Integer total, List<SeasonDto> items) {
        this.total = total;
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<SeasonDto> getItems() {
        return items;
    }

    public void setItems(List<SeasonDto> items) {
        this.items = items;
    }
}
