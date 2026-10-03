package ru.jumptojava.kinopoiskz.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jumptojava.kinopoiskz.entity.ImportJob;
import ru.jumptojava.kinopoiskz.entity.User;
import ru.jumptojava.kinopoiskz.entity.enums.ProcessType;
import ru.jumptojava.kinopoiskz.repository.ImportJobRepository;
import ru.jumptojava.kinopoiskz.repository.UserRepository;
import ru.jumptojava.kinopoiskz.security.UserDetailsImpl;
import ru.jumptojava.kinopoiskz.service.ImportJobService;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class ImportJobController {

    private final ImportJobService importJobService;
    private final ImportJobRepository importJobRepository;
    private final UserRepository userRepository;

    public ImportJobController(ImportJobService importJobService, ImportJobRepository importJobRepository, UserRepository userRepository) {
        this.importJobService = importJobService;
        this.importJobRepository = importJobRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/api/v2/imports")
    @Operation(description = "Ручной импорт фильмов и запись")
    public ImportJob postImports(@AuthenticationPrincipal UserDetailsImpl userDetails,
                            @RequestParam(required = false) Integer countries,
                            @RequestParam(required = false) Integer genres,
                            @RequestParam(required = false) String order,
                            @RequestParam(required = false) String type,
                            @RequestParam(required = false) @DecimalMin("0.0") Float ratingFrom,
                            @RequestParam(required = false) @DecimalMax("10.0") Float ratingTo,
                            @RequestParam(required = false) @Min(1895) Integer yearFrom,
                            @RequestParam(required = false) @Min(1895) Integer yearTo,
                            @Parameter(description = "Ключевое слово для поиска по названию фильма")
                                @RequestParam(required = false) String keyword,
                            @RequestParam(required = false) @Positive Integer page) {
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());
        return importJobService.submitImport(countries, genres, order, type, ratingFrom, ratingTo, yearFrom, yearTo, keyword, page, user.get(), ProcessType.MANUAL);
    }

    @GetMapping("/api/v2/imports")
    @Operation(description = "Показывает список импортов")
    public List<ImportJob> getImports() {
        return importJobRepository.findAllByOrderByStartTimeDesc();
    }
}
