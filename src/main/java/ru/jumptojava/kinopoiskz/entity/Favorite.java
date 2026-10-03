package ru.jumptojava.kinopoiskz.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "added_at")
    private LocalDate addedAt;

    public Favorite() {
    }

    public Favorite(User user, Integer filmId, LocalDate addedAt) {
        this.user = user;
        this.filmId = filmId;
        this.addedAt = addedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public LocalDate getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDate addedAt) {
        this.addedAt = addedAt;
    }
}
