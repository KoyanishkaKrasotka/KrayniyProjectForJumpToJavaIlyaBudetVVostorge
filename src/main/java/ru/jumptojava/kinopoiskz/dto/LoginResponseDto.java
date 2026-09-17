package ru.jumptojava.kinopoiskz.dto;

import ru.jumptojava.kinopoiskz.entity.enums.UserRoles;

public class LoginResponseDto {

    private String token;

    private String username;

    private UserRoles role;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String token, String username, UserRoles role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }
}
