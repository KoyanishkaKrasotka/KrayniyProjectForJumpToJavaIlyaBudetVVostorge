package ru.jumptojava.kinopoiskz.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Objects;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "staff_name_ru")
    private String nameRu;

    @Column(name = "staff_name_en")
    private String nameEn;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "description")
    private String description;

    public Person() {
    }

    public Person(Integer staffId, String nameRu, String nameEn, String posterUrl, String description) {
        this.staffId = staffId;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.posterUrl = posterUrl;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(staffId, person.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(staffId);
    }
}
