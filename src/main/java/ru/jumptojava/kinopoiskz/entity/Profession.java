package ru.jumptojava.kinopoiskz.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "professions")
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profession_key")
    private String professionKey;

    @Column(name = "profession_text")
    private String professionText;


    public Profession() {
    }

    public Profession(String professionKey, String professionText) {
        this.professionKey = professionKey;
        this.professionText = professionText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessionKey() {
        return professionKey;
    }

    public void setProfessionKey(String professionKey) {
        this.professionKey = professionKey;
    }

    public String getProfessionText() {
        return professionText;
    }

    public void setProfessionText(String professionText) {
        this.professionText = professionText;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profession that = (Profession) o;
        return Objects.equals(professionKey, that.professionKey);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(professionKey);
    }
}
