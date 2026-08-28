package ru.jumptojava.kinopoiskz.mapper;

import ru.jumptojava.kinopoiskz.dto.FilmDto;
import ru.jumptojava.kinopoiskz.entity.Film;

public class FilmMapper {

    public static FilmDto toDto(Film film) {
        return new FilmDto(film.getFilmId(), film.getFilmName(), film.getYear(), film.getRating(), film.getDescription());
    }
}