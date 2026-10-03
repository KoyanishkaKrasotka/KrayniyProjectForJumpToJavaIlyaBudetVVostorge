package ru.jumptojava.kinopoiskz.dto;

public class ImportResult {

    private FilmResponse filmResponse;
    private Integer filmsCount;
    private Integer newFilmsCount;

    public ImportResult(FilmResponse filmResponse, Integer filmsCount, Integer newFilmsCount) {
        this.filmResponse = filmResponse;
        this.filmsCount = filmsCount;
        this.newFilmsCount = newFilmsCount;
    }

    public FilmResponse getFilmResponse() {
        return filmResponse;
    }

    public Integer getFilmsCount() {
        return filmsCount;
    }

    public Integer getNewFilmsCount() {
        return newFilmsCount;
    }
}