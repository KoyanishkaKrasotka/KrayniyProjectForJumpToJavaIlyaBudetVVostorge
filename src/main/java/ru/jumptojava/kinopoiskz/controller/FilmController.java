package ru.jumptojava.kinopoiskz.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jumptojava.kinopoiskz.dto.FilmDto;
import ru.jumptojava.kinopoiskz.dto.FilmResponse;
import ru.jumptojava.kinopoiskz.service.FilmSearchService;
import ru.jumptojava.kinopoiskz.service.FilmService;

@RestController
public class FilmController {

    private final FilmService filmService;
    private final FilmSearchService filmSearchService;

    public FilmController(FilmService filmService, FilmSearchService filmSearchService) {
        this.filmService = filmService;
        this.filmSearchService = filmSearchService;
    }

    @GetMapping("/api/v2/films")
    public FilmResponse getFilms(@RequestParam(required = false) Integer countries,
                                 @RequestParam(required = false) Integer genres,
                                 @RequestParam(required = false) String order,
                                 @RequestParam(required = false) String type,
                                 @RequestParam(required = false) Float ratingFrom,
                                 @RequestParam(required = false) Float ratingTo,
                                 @RequestParam(required = false) Integer yearFrom,
                                 @RequestParam(required = false) Integer yearTo,
                                 @RequestParam(required = false) String keyword,
                                 @RequestParam(required = false) Integer page) {
        return filmService.importFilms(countries, genres, order,
                type, ratingFrom, ratingTo,
                yearFrom, yearTo, keyword, page);
    }

    @GetMapping("/api/films")
    public Page<FilmDto> searchFilms(@RequestParam(required = false) Integer yearFrom,
                                     @RequestParam(required = false) Integer yearTo,
                                     @RequestParam(required = false) Float ratingFrom,
                                     @RequestParam(required = false) Float ratingTo,
                                     @RequestParam(required = false) String keyword,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String sortBy,
                                     @RequestParam(defaultValue = "asc") String sortDirection) {

        return filmSearchService.searchFilms(yearFrom, yearTo, ratingFrom, ratingTo, keyword, page, size, sortBy, sortDirection);
    }

}
