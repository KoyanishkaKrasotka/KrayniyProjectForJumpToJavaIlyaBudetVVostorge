package ru.jumptojava.kinopoiskz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jumptojava.kinopoiskz.entity.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByStaffId(Integer staffId);

}
