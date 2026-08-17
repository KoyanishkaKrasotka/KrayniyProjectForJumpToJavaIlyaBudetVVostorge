package ru.jumptojava.kinopoiskz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "film_id")
    Integer filmId;

    @Column(name = "film_name")
    String filmName;

    @Column(name = "year")
    Integer year;

    @Column(name = "rating")
    Float rating;

    @Column(name = "description")
    String description;

    public Film() {
    }

    public Film(Integer filmId, String filmName, Integer year, Float rating, String description) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.year = year;
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId

        ;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
