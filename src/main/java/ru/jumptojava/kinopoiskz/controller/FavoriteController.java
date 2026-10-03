package ru.jumptojava.kinopoiskz.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jumptojava.kinopoiskz.entity.Favorite;
import ru.jumptojava.kinopoiskz.entity.User;
import ru.jumptojava.kinopoiskz.repository.UserRepository;
import ru.jumptojava.kinopoiskz.security.UserDetailsImpl;
import ru.jumptojava.kinopoiskz.service.FavoriteService;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class FavoriteController {

    private final FavoriteService favoriteService;
    private final UserRepository userRepository;

    public FavoriteController(FavoriteService favoriteService, UserRepository userRepository) {
        this.favoriteService = favoriteService;
        this.userRepository = userRepository;
    }

    @PostMapping("/api/favorites/{filmId}")
    @Operation(description = "Добавление фильма в избранное")
    public void addToFavorites(@AuthenticationPrincipal UserDetailsImpl userDetails,
                               @PathVariable Integer filmId) {
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
        favoriteService.addFilmToFavorites(filmId, user.get());
    }

    @PostMapping("/api/favorites/{filmId}/delete")
    @Operation(description = "Удаление фильма из избранного")
    public void deleteFromFavorites(@AuthenticationPrincipal UserDetailsImpl userDetails,
                               @PathVariable Integer filmId) {
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
        favoriteService.deleteFilmFromFavorites(filmId, user.get());
    }

    @GetMapping("/api/favorites/")
    @Operation(description = "Показывает список избранного")
    public List<Favorite> getFavorites(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
        return favoriteService.getFavorite(user.get());
    }


}
