package ru.jumptojava.kinopoiskz.dto;

import java.time.LocalDate;
import java.util.List;

public class PremieresDto {

    private Integer kinopoiskId;

    private String nameRu;

    private String nameEn;

    private String year;

    private String posterUrl;

    private String posterUrlPreview;

    private List<Countries> countries;

    private List<Genres> genres;

    private Integer duration;

    private LocalDate premiereRu;

    public PremieresDto() {
    }

    public PremieresDto(Integer kinopoiskId, String nameRu, String nameEn, String year, String posterUrl, String posterUrlPreview, List<Countries> countries, List<Genres> genres, Integer duration, LocalDate premiereRu) {
        this.kinopoiskId = kinopoiskId;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.year = year;
        this.posterUrl = posterUrl;
        this.posterUrlPreview = posterUrlPreview;
        this.countries = countries;
        this.genres = genres;
        this.duration = duration;
        this.premiereRu = premiereRu;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getPremiereRu() {
        return premiereRu;
    }

    public void setPremiereRu(LocalDate premiereRu) {
        this.premiereRu = premiereRu;
    }
}
