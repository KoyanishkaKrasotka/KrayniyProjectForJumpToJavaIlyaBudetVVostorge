package ru.jumptojava.kinopoiskz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.entity.Film;
import ru.jumptojava.kinopoiskz.repository.FilmRepository;

@Service
public class FilmSearchService {

    private final FilmRepository filmRepository;

    public FilmSearchService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Page<Film> searchFilms(Integer yearFrom, Integer yearTo, Float ratingFrom, Float ratingTo,
                                  String keyword, int page, int size, String sortBy, String sortDirection) {

        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

        return filmRepository.search(yearFrom, yearTo, ratingFrom, ratingTo, keyword, pageable);
    }


}
