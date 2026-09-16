package ru.jumptojava.kinopoiskz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "film_persons")
public class FilmPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    public FilmPerson() {
    }

    public FilmPerson(Film film, Person person, Profession profession) {
        this.film = film;
        this.person = person;
        this.profession = profession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
