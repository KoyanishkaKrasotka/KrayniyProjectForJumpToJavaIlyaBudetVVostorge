package ru.jumptojava.kinopoiskz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.jumptojava.kinopoiskz.dto.enums.CollectionType;

import java.util.List;

public class CollectionFilmsDto {

    private Integer kinopoiskId;

    private String nameRu;

    private String nameEn;

    private String nameOriginal;

    private List<Countries> countries;

    private List<Genres> genres;

    private Float ratingKinopoisk;

    @JsonProperty("ratingImbd")
    private Float ratingImdb;

    private Integer year;

    private String type;

    private String posterUrl;

    private String posterUrlPreview;

    public CollectionFilmsDto() {
    }

    public CollectionFilmsDto(Integer kinopoiskId, String nameRu, String nameEn, String nameOriginal, List<Countries> countries, List<Genres> genres, Float ratingKinopoisk, Float ratingImdb, Integer year, String type, String posterUrl, String posterUrlPreview) {
        this.kinopoiskId = kinopoiskId;
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
    }

    public Integer getKinopoiskId() {
        return kinopoiskId;
    }

    public void setKinopoiskId(Integer kinopoiskId) {
        this.kinopoiskId = kinopoiskId;
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
}
