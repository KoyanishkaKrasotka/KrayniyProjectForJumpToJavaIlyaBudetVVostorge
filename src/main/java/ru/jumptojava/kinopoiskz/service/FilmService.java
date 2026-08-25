package ru.jumptojava.kinopoiskz.service;

import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.dto.FilmItem;
import ru.jumptojava.kinopoiskz.dto.FilmResponse;
import ru.jumptojava.kinopoiskz.entity.Film;
import ru.jumptojava.kinopoiskz.repository.FilmRepository;

@Service
public class FilmService {

    private final KinopoiskClientService kinopoiskClientService;
    private final FilmRepository filmRepository;

    public FilmService(KinopoiskClientService kinopoiskClientService, FilmRepository filmRepository) {
        this.kinopoiskClientService = kinopoiskClientService;
        this.filmRepository = filmRepository;
    }

    public FilmResponse importFilms(Integer countries, Integer genres, String order, String type,
                                    Float ratingFrom, Float ratingTo,
                                    Integer yearFrom, Integer yearTo,
                                    String keyword, Integer page) {

        FilmResponse filmResponse = kinopoiskClientService.getFilms(countries, genres, order, type,
                ratingFrom, ratingTo,
                yearFrom, yearTo,
                keyword, page);

        if (filmResponse.getItems() != null) {
            for (FilmItem item: filmResponse.getItems()) {
                if(!filmRepository.existsByFilmId(item.getKinopoiskId())) {
                    String filmName = item.getNameRu() != null ? item.getNameRu() : item.getNameOriginal();
                    Film film = new Film(item.getKinopoiskId(), filmName, item.getYear(), item.getRatingKinopoisk(), null);
                    filmRepository.save(film);
                }
            }
        }

        return filmResponse;
    }
}
