package ru.jumptojava.kinopoiskz.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.jumptojava.kinopoiskz.entity.Film;

import java.util.List;

@XmlRootElement(name = "films")
public class FilmsXmlWrapper {

    private List<Film> film;

    public FilmsXmlWrapper() {
    }

    public FilmsXmlWrapper(List<Film> film) {
        this.film = film;
    }

    @XmlElement(name = "film")
    public List<Film> getFilm() {
        return film;
    }

    public void setFilm(List<Film> film) {
        this.film = film;
    }
}