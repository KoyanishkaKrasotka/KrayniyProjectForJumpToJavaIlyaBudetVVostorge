package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class ReviewResponse {

    private Integer total;

    private Integer totalPages;

    private Integer totalPositiveReviews;

    private Integer totalNegativeReviews;

    private Integer totalNeutralReviews;

    private List<ReviewsItem> items;

    public ReviewResponse() {
    }

    public ReviewResponse(Integer total, Integer totalPages, Integer totalPositiveReviews, Integer totalNegativeReviews, Integer totalNeutralReviews, List<ReviewsItem> items) {
        this.total = total;
        this.totalPages = totalPages;
        this.totalPositiveReviews = totalPositiveReviews;
        this.totalNegativeReviews = totalNegativeReviews;
        this.totalNeutralReviews = totalNeutralReviews;
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

    public Integer getTotalPositiveReviews() {
        return totalPositiveReviews;
    }

    public void setTotalPositiveReviews(Integer totalPositiveReviews) {
        this.totalPositiveReviews = totalPositiveReviews;
    }

    public Integer getTotalNegativeReviews() {
        return totalNegativeReviews;
    }

    public void setTotalNegativeReviews(Integer totalNegativeReviews) {
        this.totalNegativeReviews = totalNegativeReviews;
    }

    public Integer getTotalNeutralReviews() {
        return totalNeutralReviews;
    }

    public void setTotalNeutralReviews(Integer totalNeutralReviews) {
        this.totalNeutralReviews = totalNeutralReviews;
    }

    public List<ReviewsItem> getItems() {
        return items;
    }

    public void setItems(List<ReviewsItem> items) {
        this.items = items;
    }


}
