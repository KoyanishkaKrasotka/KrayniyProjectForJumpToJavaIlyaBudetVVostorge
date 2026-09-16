package ru.jumptojava.kinopoiskz.dto;

import java.util.List;

public class FilmFullInfo {

    private Integer kinopoiskId;

    private String kinopoiskHDId;

    private String imdbId;

    private String nameRu;

    private String nameEn;

    private String nameOriginal;

    private List<Countries> countries;

    private List<Genres> genres;

    private Float ratingKinopoisk;

    private Float ratingImdb;

    private Integer year;

    private String type;

    private String posterUrl;

    private String posterUrlPreview;

    private Integer filmLength;

    private Integer reviewsCount;

    private Float ratingGoodReview;

    private String webUrl;

    private String slogan;

    private String description;

    private boolean completed;

    public FilmFullInfo() {
    }

    public FilmFullInfo(Integer kinopoiskId, Integer kinopoiskHDId, String imdbId, String nameRu, String nameEn, String nameOriginal, List<Countries> countries, List<Genres> genres, Float ratingKinopoisk, Float ratingImdb, Integer year, String type, String posterUrl, String posterUrlPreview, Integer filmLength, Integer reviewsCount, Float ratingGoodReview, String webUrl, String slogan, String description, boolean completed) {
        this.kinopoiskId = kinopoiskId;
        this.kinopoiskHDId = kinopoiskHDId;
        this.imdbId = imdbId;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.nameOriginal = nameOriginal;
        this.countries = countries;
        this.genres = genres;
        this.ratingKinopoisk = ratingKinopoisk;
        this.ratingImdb = ratingImdb;
        this.year = year;
        this.type = type;
        this.posterUrl = posterUrl;
        this.posterUrlPreview = posterUrlPreview;
        this.filmLength = filmLength;
        this.reviewsCount = reviewsCount;
        this.ratingGoodReview = ratingGoodReview;
        this.webUrl = webUrl;
        this.slogan = slogan;
        this.description = description;
        this.completed = completed;
    }

    public Integer getKinopoiskId() {
        return kinopoiskId;
    }

    public void setKinopoiskId(Integer kinopoiskId) {
        this.kinopoiskId = kinopoiskId;
    }

    public Integer getKinopoiskHDId() {
        return kinopoiskHDId;
    }

    public void setKinopoiskHDId(Integer kinopoiskHDId) {
        this.kinopoiskHDId = kinopoiskHDId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public List<Countries> getCountries() {
        return countries;
    }

    public void setCountries(List<Countries> countries) {
        this.countries = countries;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public Float getRatingKinopoisk() {
        return ratingKinopoisk;
    }

    public void setRatingKinopoisk(Float ratingKinopoisk) {
        this.ratingKinopoisk = ratingKinopoisk;
    }

    public Float getRatingImdb() {
        return ratingImdb;
    }

    public void setRatingImdb(Float ratingImdb) {
        this.ratingImdb = ratingImdb;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getPosterUrlPreview() {
        return posterUrlPreview;
    }

    public void setPosterUrlPreview(String posterUrlPreview) {
        this.posterUrlPreview = posterUrlPreview;
    }

    public Integer getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(Integer filmLength) {
        this.filmLength = filmLength;
    }

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public Float getRatingGoodReview() {
        return ratingGoodReview;
    }

    public void setRatingGoodReview(Float ratingGoodReview) {
        this.ratingGoodReview = ratingGoodReview;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
