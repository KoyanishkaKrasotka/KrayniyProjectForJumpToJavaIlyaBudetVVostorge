package ru.jumptojava.kinopoiskz.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jumptojava.kinopoiskz.entity.Favorite;
import ru.jumptojava.kinopoiskz.entity.User;
import ru.jumptojava.kinopoiskz.exception.FilmAlreadyExistsException;
import ru.jumptojava.kinopoiskz.exception.FilmNotFoundException;
import ru.jumptojava.kinopoiskz.repository.FavoriteRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public void addFilmToFavorites(Integer filmId, User user) {
        if (!favoriteRepository.existsByFilmIdAndUser(filmId, user)) {
            Favorite favorite = new Favorite(user, filmId, LocalDate.now());
            favoriteRepository.save(favorite);
        } else throw new FilmAlreadyExistsException("Данного фильм уже в списке избранного");
    }

    @Transactional
    public void deleteFilmFromFavorites(Integer filmId, User user) {
        if (favoriteRepository.existsByFilmIdAndUser(filmId, user)) {
            favoriteRepository.deleteByUserAndFilmId(user, filmId);
        } else throw new FilmNotFoundException("Данного фильма нет в списке избарнных");
    }

    public List<Favorite> getFavorite(User user) {
        List<Favorite> favorites = favoriteRepository.findByUser(user);
        return favorites;
    }
}
