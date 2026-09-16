package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class PremiereResponse {

    private Integer total;

    private List<PremieresDto> items;

    public PremiereResponse() {
    }

    public PremiereResponse(Integer total, List<PremieresDto> items) {
        this.total = total;
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<PremieresDto> getItems() {
        return items;
    }

    public void setItems(List<PremieresDto> items) {
        this.items = items;
    }
}
