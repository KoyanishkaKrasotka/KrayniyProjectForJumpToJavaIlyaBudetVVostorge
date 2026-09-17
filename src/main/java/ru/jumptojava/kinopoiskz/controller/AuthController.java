package ru.jumptojava.kinopoiskz.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.jumptojava.kinopoiskz.dto.LoginRequestDto;
import ru.jumptojava.kinopoiskz.dto.LoginResponseDto;
import ru.jumptojava.kinopoiskz.dto.RegisterRequestDto;
import ru.jumptojava.kinopoiskz.service.AuthService;

@RestController
@Validated
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/api/auth/register")
    @Operation(description = "Регистрация пользователя")
    public ResponseEntity<Void> postRegistration(@RequestBody @Valid RegisterRequestDto registerRequestDto) {
        authService.registerUser(registerRequestDto.getUsername(), registerRequestDto.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/api/auth/login")
    @Operation(description = "Авторизация пользователя")
    public LoginResponseDto postLogin(@RequestBody @Valid LoginRequestDto loginRequestDto) {
        return authService.loginUser(loginRequestDto.getUsername(), loginRequestDto.getPassword());
    }
}
