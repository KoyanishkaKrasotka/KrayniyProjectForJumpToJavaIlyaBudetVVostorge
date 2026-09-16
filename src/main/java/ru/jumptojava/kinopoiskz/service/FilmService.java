package ru.jumptojava.kinopoiskz.service;

import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.dto.*;
import ru.jumptojava.kinopoiskz.entity.*;
import ru.jumptojava.kinopoiskz.exception.FilmNotFoundException;
import ru.jumptojava.kinopoiskz.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {


    private final KinopoiskClientService kinopoiskClientService;
    private final FilmRepository filmRepository;
    private final GenreRepository genreRepository;
    private final CountryRepository countryRepository;
    private final PersonRepository personRepository;
    private final ProfessionRepository professionRepository;
    private final FilmPersonRepository filmPersonRepository;

    public FilmService(KinopoiskClientService kinopoiskClientService, FilmRepository filmRepository, GenreRepository genreRepository, CountryRepository countryRepository, PersonRepository personRepository, ProfessionRepository professionRepository, FilmPersonRepository filmPersonRepository) {
        this.kinopoiskClientService = kinopoiskClientService;
        this.filmRepository = filmRepository;
        this.genreRepository = genreRepository;
        this.countryRepository = countryRepository;
        this.personRepository = personRepository;
        this.professionRepository = professionRepository;
        this.filmPersonRepository = filmPersonRepository;
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
                    for (Genres genre: item.getGenres()) {
                        film.getGenres().add(resolveGenre(genre.getGenre()));
                    }
                    for (Countries country: item.getCountries()) {
                        film.getCountries().add(resolveCountry(country.getCountry()));
                    }
                    filmRepository.save(film);
                    importStaff(film);
                }
            }
        }

        return filmResponse;
    }

    public List<StaffItem> importStaff(Film film) {

        List<StaffItem> staffItem = kinopoiskClientService.getStaff(film.getFilmId());

        if (staffItem != null) {
            for (StaffItem item: staffItem) {
                Person person = resolvePerson(item.getStaffId(), item.getNameRu(), item.getNameEn(), item.getPosterUrl(), item.getDescription());

                Profession profession = resolveProfession(item.getProfessionKey(), item.getProfessionText());

                if (!filmPersonRepository.existsByFilmAndPersonAndProfession(film, person, profession)) {
                    filmPersonRepository.save(new FilmPerson(film, person, profession));
                }
            }
        }
        return staffItem;
    }

    public void updateFilmDetails(Integer filmId) {
        Optional<Film> film = filmRepository.findByFilmId(filmId);

        if (film.isEmpty()) {
             throw new FilmNotFoundException("Данного фильма нет в локальной базе данных");
        }
        FilmFullInfo filmFullInfo = kinopoiskClientService.getFilmById(filmId);
        Film localFilm = film.get();
        localFilm.setDescription(filmFullInfo.getDescription());
        filmRepository.save(localFilm);
    }

    private Genre resolveGenre(String name) {
        Optional<Genre> genre = genreRepository.findByName(name);
        if (genre.isEmpty()) {
            return new Genre(name);
        }
        return genre.get();
    }

    private Country resolveCountry(String name) {
        Optional<Country> country = countryRepository.findByName(name);
        if (country.isEmpty()) {
            return new Country(name);
        }
        return country.get();
    }

    private Person resolvePerson(Integer staffId, String nameRu, String nameEn, String posterUrl, String description) {
        Optional<Person> person = personRepository.findByStaffId(staffId);
        if (person.isEmpty()) {
            Person newPerson = new Person(staffId, nameRu, nameEn, posterUrl, description);
            personRepository.save(newPerson);
            return newPerson;
        }
        return person.get();
    }

    private Profession resolveProfession(String professionKey, String professionText) {
        Optional<Profession> profession = professionRepository.findByProfessionKey(professionKey);
        if (profession.isEmpty()) {
            Profession newProfession = new Profession(professionKey, professionText);
            professionRepository.save(newProfession);
            return newProfession;
        }
        return profession.get();
    }
}
