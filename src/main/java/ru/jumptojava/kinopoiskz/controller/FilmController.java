package ru.jumptojava.kinopoiskz.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.*;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.jumptojava.kinopoiskz.dto.*;
import ru.jumptojava.kinopoiskz.dto.enums.CollectionType;
import ru.jumptojava.kinopoiskz.dto.enums.ImageType;
import ru.jumptojava.kinopoiskz.dto.enums.PremiereMonth;
import ru.jumptojava.kinopoiskz.dto.enums.ReviewOrder;
import ru.jumptojava.kinopoiskz.service.FilmSearchService;
import ru.jumptojava.kinopoiskz.service.FilmService;
import ru.jumptojava.kinopoiskz.service.KinopoiskClientService;

@RestController
@Validated
public class FilmController {

    private final FilmService filmService;
    private final FilmSearchService filmSearchService;
    private final KinopoiskClientService kinopoiskClientService;

    public FilmController(FilmService filmService, FilmSearchService filmSearchService, KinopoiskClientService kinopoiskClientService) {
        this.filmService = filmService;
        this.filmSearchService = filmSearchService;
        this.kinopoiskClientService = kinopoiskClientService;
    }

    @GetMapping("/api/v2/films")
    public FilmResponse getFilms(@RequestParam(required = false) Integer countries,
                                 @RequestParam(required = false) Integer genres,
                                 @RequestParam(required = false) String order,
                                 @RequestParam(required = false) String type,
                                 @RequestParam(required = false) @DecimalMin("0.0") Float ratingFrom,
                                 @RequestParam(required = false) @DecimalMax("10.0") Float ratingTo,
                                 @RequestParam(required = false) @Min(1895) Integer yearFrom,
                                 @RequestParam(required = false) @Min(1895) Integer yearTo,
                                 @Parameter(description = "Ключевое слово для поиска по названию фильма")
                                 @RequestParam(required = false) String keyword,
                                 @RequestParam(required = false) @Positive Integer page) {
        return filmService.importFilms(countries, genres, order,
                type, ratingFrom, ratingTo,
                yearFrom, yearTo, keyword, page);
    }

    @GetMapping("/api/films")
    @Operation(summary = "Поиск фильмов в локальной БД с фильтрами и пагинацией")
    public Page<FilmDto> searchFilms(@RequestParam(required = false) @Min(1895) Integer yearFrom,
                                     @RequestParam(required = false) @Min(1895) Integer yearTo,
                                     @RequestParam(required = false) @DecimalMin("0.0") Float ratingFrom,
                                     @RequestParam(required = false) @DecimalMax("10.0") Float ratingTo,
                                     @Parameter(description = "Ключевое слово для поиска по названию фильма")
                                     @RequestParam(required = false) String keyword,
                                     @RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                     @RequestParam(defaultValue = "10") @Positive @Max(100) int size,
                                     @Parameter(description = "Сортировать можно по разным параметрам id, year, rating; default = id")
                                     @RequestParam(defaultValue = "id") String sortBy,
                                     @Parameter(description = "Отображение по возрастанию, можно сделать по убиыванию")
                                     @RequestParam(defaultValue = "asc") String sortDirection) {

        return filmSearchService.searchFilms(yearFrom, yearTo, ratingFrom, ratingTo, keyword, page, size, sortBy, sortDirection);
    }

    @PatchMapping("/api/v2/films/{filmId}/details")
    @Operation(summary = "Обновление информации о локальном фильме по запросу пользователя")
    public void updateFilmById(@PathVariable Integer filmId) {
        filmService.updateFilmDetails(filmId);
    }

    @GetMapping("/api/v2/films/{filmId}/reviews")
    @Operation(summary = "Получение отзывов по фильму")
    public ReviewResponse getReviews(@PathVariable Integer filmId,
                                     @RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                     @Parameter(description = "Метод сортировки")
                                     @RequestParam(required = false) ReviewOrder order) {
        return kinopoiskClientService.getReviews(filmId,page, order );
    }

    @GetMapping("/api/v2/films/{filmId}/seasons")
    @Operation(summary = "Информация по количеству сезонов и количеству эпизодов")
    public SeasonsResponse getSeasons(@PathVariable Integer filmId) {
        return kinopoiskClientService.getSeasons(filmId);
    }

    @GetMapping("/api/v2/films/{filmId}/similar")
    @Operation(summary = "Похожие фильмы на тот, что задается параметром")
    public SimilarFilmResponse getSimilarFilms(@PathVariable Integer filmId) {
        return kinopoiskClientService.getSimilarFilms(filmId);
    }

    @GetMapping("/api/v2/films/{filmId}/images")
    @Operation(summary = "Получение изображений фильма")
    public ImageResponse getImages(@PathVariable Integer filmId,
                                     @RequestParam(defaultValue = "1") @Positive int page,
                                     @Parameter(description = "Вид изображения - постер, скриншот итд")
                                     @RequestParam(required = false) ImageType type) {
        return kinopoiskClientService.getImage(filmId, page, type);
    }

    @GetMapping("/api/v2/films/premieres")
    @Operation(summary = "Получение свежих премьер")
    public PremiereResponse getPremieres(@RequestParam @Min(1895) int year,
                                        @RequestParam PremiereMonth month) {
        return kinopoiskClientService.getPremieres(year, month);
    }

    @GetMapping("/api/v2/films/collections")
    @Operation(summary = "Получение разных подборок")
    public CollectionResponse getCollections(@RequestParam(defaultValue = "1") @Positive int page,
                                   @Parameter(description = "Разные подборки")
                                   @RequestParam(required = false, defaultValue = "TOP_POPULAR_ALL")  CollectionType type) {
        return kinopoiskClientService.getCollections(type, page);
    }

    @GetMapping("/api/v2/films/keyword_search")
    @Operation(summary = "Поиск по ключевому слову")
    public SearchByKeywordResponse getSearchByKeyword(@RequestParam(defaultValue = "1") @Positive int page,
                                             @RequestParam  String keyword) {
        return kinopoiskClientService.getFilmsByKeyword(keyword, page);
    }

}
