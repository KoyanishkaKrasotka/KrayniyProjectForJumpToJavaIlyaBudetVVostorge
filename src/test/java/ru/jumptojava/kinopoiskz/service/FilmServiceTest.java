package ru.jumptojava.kinopoiskz.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.jumptojava.kinopoiskz.entity.Country;
import ru.jumptojava.kinopoiskz.entity.Genre;
import ru.jumptojava.kinopoiskz.repository.CountryRepository;
import ru.jumptojava.kinopoiskz.repository.GenreRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FilmServiceTest {

    @Mock
    GenreRepository genreRepository;
    @Mock
    CountryRepository countryRepository;
    @InjectMocks
    FilmService filmService;

    public FilmServiceTest() {
    }

    @Test
    void resolveGenreIfExists() {
        Genre genre = new Genre("Comedy");
        when(genreRepository.findByName("Comedy")).thenReturn(Optional.of(genre));
        Genre result = filmService.resolveGenre("Comedy");
        assertEquals(genre, result);
    }

    @Test
    void resolveGenreIfNotExists() {
        when(genreRepository.findByName("Horror")).thenReturn(Optional.empty());
        Genre result = filmService.resolveGenre("Horror");
        assertEquals(new Genre("Horror"), result);
    }

    @Test
    void resolveCountryIfExists() {
        Country country = new Country("USA");
        when(countryRepository.findByName("USA")).thenReturn(Optional.of(country));
        Country result = filmService.resolveCountry("USA");
        assertEquals(country, result);
    }

    @Test
    void resolveCountryIfNotExists() {
        when(countryRepository.findByName("Russia")).thenReturn(Optional.empty());
        Country result = filmService.resolveCountry("Russia");
        assertEquals(new Country("Russia"), result);
    }


}