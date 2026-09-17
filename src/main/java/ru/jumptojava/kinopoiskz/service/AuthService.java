package ru.jumptojava.kinopoiskz.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.dto.LoginResponseDto;
import ru.jumptojava.kinopoiskz.entity.User;
import ru.jumptojava.kinopoiskz.entity.enums.UserRoles;
import ru.jumptojava.kinopoiskz.exception.UsernameAlreadyExistException;
import ru.jumptojava.kinopoiskz.repository.UserRepository;
import ru.jumptojava.kinopoiskz.security.JwtUtil;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public void registerUser(String username, String password) {

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            throw new UsernameAlreadyExistException("Пользователь с таким Username уже есть, используйте другой Username");
        }
        User newUser = new User(username, passwordEncoder.encode(password), UserRoles.USER, true);
        userRepository.save(newUser);
    }

    public LoginResponseDto loginUser(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)).isAuthenticated();
        Optional<User> user = userRepository.findByUsername(username);
        return new LoginResponseDto(jwtUtil.generateToken(username), username, user.get().getRole());
    }
}
