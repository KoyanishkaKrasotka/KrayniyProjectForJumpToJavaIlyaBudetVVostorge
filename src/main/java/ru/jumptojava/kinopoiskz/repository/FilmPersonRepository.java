package ru.jumptojava.kinopoiskz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jumptojava.kinopoiskz.entity.Film;
import ru.jumptojava.kinopoiskz.entity.FilmPerson;
import ru.jumptojava.kinopoiskz.entity.Person;
import ru.jumptojava.kinopoiskz.entity.Profession;

public interface FilmPersonRepository extends JpaRepository<FilmPerson, Long> {

    boolean existsByFilmAndPersonAndProfession(Film film, Person person, Profession profession);
}
