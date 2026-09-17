package ru.jumptojava.kinopoiskz.entity;

import jakarta.persistence.*;
import ru.jumptojava.kinopoiskz.entity.enums.UserRoles;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usernames", unique = true)
    private String username;

    @Column(name = "passwords")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private UserRoles role;

    @Column(name = "enabled")
    private Boolean enabled;

    public User() {
    }

    public User(String username, String password, UserRoles role, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
