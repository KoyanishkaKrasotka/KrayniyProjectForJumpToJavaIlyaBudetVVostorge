package ru.jumptojava.kinopoiskz.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenreTest {

    @Test
    void equals_whenSameName_returnsTrue() {
        Genre genre1 = new Genre("Comedy");
        Genre genre2 = new Genre("Comedy");

        assertEquals(genre1, genre2);
        assertEquals(genre1.hashCode(), genre2.hashCode());
    }

    @Test
    void equals_whenDifferentName_returnsFalse() {
        Genre genre1 = new Genre("Comedy");
        Genre genre2 = new Genre("Horror");

        assertNotEquals(genre1, genre2);
    }
}