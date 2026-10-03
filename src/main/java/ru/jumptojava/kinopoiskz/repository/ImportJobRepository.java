package ru.jumptojava.kinopoiskz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jumptojava.kinopoiskz.entity.ImportJob;

import java.util.List;

@Repository
public interface ImportJobRepository extends JpaRepository<ImportJob, Long> {

    List<ImportJob> findAllByOrderByStartTimeDesc();
}
