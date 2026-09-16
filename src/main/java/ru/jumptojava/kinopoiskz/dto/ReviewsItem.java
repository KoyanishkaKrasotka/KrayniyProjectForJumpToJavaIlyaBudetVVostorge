package ru.jumptojava.kinopoiskz.dto;

import java.time.LocalDateTime;

public class ReviewsItem {

    private Integer kinopoiskId;

    private String type;

    private LocalDateTime date;

    private Integer positiveRating;

    private Integer negativeRating;

    private String author;

    private String title;

    private String description;

    public ReviewsItem() {
    }

    public ReviewsItem(Integer kinopoiskId, String type, LocalDateTime date, Integer positiveRating, Integer negativeRating, String author, String title, String description) {
        this.kinopoiskId = kinopoiskId;
        this.type = type;
        this.date = date;
        this.positiveRating = positiveRating;
        this.negativeRating = negativeRating;
        this.author = author;
        this.title = title;
        this.description = description;
    }

    public Integer getKinopoiskId() {
        return kinopoiskId;
    }

    public void setKinopoiskId(Integer kinopoiskId) {
        this.kinopoiskId = kinopoiskId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getPositiveRating() {
        return positiveRating;
    }

    public void setPositiveRating(Integer positiveRating) {
        this.positiveRating = positiveRating;
    }

    public Integer getNegativeRating() {
        return negativeRating;
    }

    public void setNegativeRating(Integer negativeRating) {
        this.negativeRating = negativeRating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
