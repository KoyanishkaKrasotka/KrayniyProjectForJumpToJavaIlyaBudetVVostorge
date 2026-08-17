package ru.jumptojava.kinopoiskz.dto;

public class Genres {

    private String genre;

    public Genres() {
    }

    public Genres(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genres{" +
                "genre='" + genre + '\'' +
                '}';
    }
}
