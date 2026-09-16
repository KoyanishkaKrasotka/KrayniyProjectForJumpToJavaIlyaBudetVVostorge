package ru.jumptojava.kinopoiskz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jumptojava.kinopoiskz.entity.Country;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByName(String name);
}
