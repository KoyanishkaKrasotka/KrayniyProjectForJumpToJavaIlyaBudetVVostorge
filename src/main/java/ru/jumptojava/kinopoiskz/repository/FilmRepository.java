package ru.jumptojava.kinopoiskz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.jumptojava.kinopoiskz.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

    boolean existsByFilmId(Integer filmId);

    @Query("SELECT f FROM Film f WHERE " +
            "(:yearFrom IS NULL OR f.year >= :yearFrom) AND " +
            "(:yearTo IS NULL OR f.year <= :yearTo) AND " +
            "(:ratingFrom IS NULL OR f.rating >= :ratingFrom) AND " +
            "(:ratingTo IS NULL OR f.rating <= :ratingTo) AND " +
            "(:keyword IS NULL OR LOWER(f.filmName) LIKE LOWER(CONCAT('%', CAST(:keyword AS string), '%')))")
    Page<Film> search(@Param("yearFrom") Integer yearFrom,
                      @Param("yearTo") Integer yearTo,
                      @Param("ratingFrom") Float ratingFrom,
                      @Param("ratingTo") Float ratingTo,
                      @Param("keyword") String keyword,
                      Pageable pageable);
}
