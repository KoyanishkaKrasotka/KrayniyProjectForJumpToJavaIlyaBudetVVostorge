package ru.jumptojava.kinopoiskz.dto;

import java.time.LocalDate;

public class Episode {

    private Integer seasonNumber;

    private Integer episodeNumber;

    private String nameRu;

    private String nameEn;

    private String synopsis;

    private LocalDate releaseDate;

    public Episode() {
    }

    public Episode(Integer seasonNumber, Integer episodeNumber, String nameRu, String nameEn, String synopsis, LocalDate releaseDate) {
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
