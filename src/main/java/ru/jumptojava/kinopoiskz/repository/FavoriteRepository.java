package ru.jumptojava.kinopoiskz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jumptojava.kinopoiskz.entity.Favorite;
import ru.jumptojava.kinopoiskz.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUser(User user);

    void deleteByUserAndFilmId(User user, Integer filmId);

    boolean existsByFilmIdAndUser(Integer filmId, User user);
}
