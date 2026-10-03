package ru.jumptojava.kinopoiskz.dto;

public class ImportMessage {

    private Integer countries;

    private Integer genres;

    private String order;

    private String type;

    private Float ratingFrom;

    private Float ratingTo;

    private Integer yearFrom;

    private Integer yearTo;

    private String keyword;

    private Integer page;

    private Long jobId;

    public ImportMessage() {
    }

    public ImportMessage(Integer countries, Integer genres, String order, String type, Float ratingFrom, Float ratingTo, Integer yearFrom, Integer yearTo, String keyword, Integer page, Long jobId) {
        this.countries = countries;
        this.genres = genres;
        this.order = order;
        this.type = type;
        this.ratingFrom = ratingFrom;
        this.ratingTo = ratingTo;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.keyword = keyword;
        this.page = page;
        this.jobId = jobId;
    }

    public Integer getCountries() {
        return countries;
    }

    public void setCountries(Integer countries) {
        this.countries = countries;
    }

    public Integer getGenres() {
        return genres;
    }

    public void setGenres(Integer genres) {
        this.genres = genres;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getRatingFrom() {
        return ratingFrom;
    }

    public void setRatingFrom(Float ratingFrom) {
        this.ratingFrom = ratingFrom;
    }

    public Float getRatingTo() {
        return ratingTo;
    }

    public void setRatingTo(Float ratingTo) {
        this.ratingTo = ratingTo;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}
