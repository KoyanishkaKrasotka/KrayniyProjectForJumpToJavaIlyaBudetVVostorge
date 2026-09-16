package ru.jumptojava.kinopoiskz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jumptojava.kinopoiskz.entity.Profession;

import java.util.Optional;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {

    Optional<Profession> findByProfessionKey(String professionKey);
}
