package ru.jumptojava.kinopoiskz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jumptojava.kinopoiskz.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

    boolean existsByFilmId(Integer filmId);
}
