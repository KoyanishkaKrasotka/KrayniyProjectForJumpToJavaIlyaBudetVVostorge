package ru.jumptojava.kinopoiskz.service;

import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.dto.ImportMessage;
import ru.jumptojava.kinopoiskz.dto.ImportResult;
import ru.jumptojava.kinopoiskz.entity.ImportJob;
import ru.jumptojava.kinopoiskz.entity.User;
import ru.jumptojava.kinopoiskz.entity.enums.ProcessType;
import ru.jumptojava.kinopoiskz.entity.enums.StatusOfProcess;
import ru.jumptojava.kinopoiskz.repository.ImportJobRepository;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ImportJobService {

    private final FilmService filmService;
    private final ImportJobRepository importJobRepository;
    private final ImportProducerService importProducerService;

    public ImportJobService(FilmService filmService, ImportJobRepository importJobRepository, ImportProducerService importProducerService) {
        this.filmService = filmService;
        this.importJobRepository = importJobRepository;
        this.importProducerService = importProducerService;
    }

    public ImportJob runImport(Integer countries, Integer genres, String order, String type,
                               Float ratingFrom, Float ratingTo,
                               Integer yearFrom, Integer yearTo,
                               String keyword, Integer page,
                               User user, ProcessType processType) {

        LocalDateTime startTime = LocalDateTime.now();
        Instant startInstant = Instant.now();

        ImportJob importJob;
        try {
            ImportResult result = filmService.importFilmsWithStats(countries, genres, order, type,
                    ratingFrom, ratingTo, yearFrom, yearTo, keyword, page);

            Duration processingTime = Duration.between(startInstant, Instant.now());

            importJob = new ImportJob(startTime, (int) processingTime.toSeconds(),
                    result.getFilmsCount(), result.getNewFilmsCount(),
                    processType, StatusOfProcess.SUCCESS, user);

        } catch (RuntimeException e) {
            Duration processingTime = Duration.between(startInstant, Instant.now());

            importJob = new ImportJob(startTime, (int) processingTime.toSeconds(),
                    0, 0, processType, StatusOfProcess.FAILED, user);

            importJobRepository.save(importJob);
            throw e;
        }

        return importJobRepository.save(importJob);
    }

    public ImportJob submitImport(Integer countries, Integer genres, String order, String type,
                                  Float ratingFrom, Float ratingTo,
                                  Integer yearFrom, Integer yearTo,
                                  String keyword, Integer page,
                                  User user, ProcessType processType) {

        ImportJob importJob = new ImportJob(LocalDateTime.now(), null, null, null, processType, StatusOfProcess.IN_PROGRESS, user);
        importJobRepository.save(importJob);
        ImportMessage importMessage = new ImportMessage(countries, genres, order, type, ratingFrom, ratingTo, yearFrom, yearTo, keyword, page, importJob.getId());
        importProducerService.sendImportMessage(importMessage);
        return importJob;
    }

    public void completeImportSuccess(Long jobId, ImportResult result) {
        ImportJob importJob = importJobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("ImportJob с id " + jobId + " не найден"));

        Duration processingTime = Duration.between(importJob.getStartTime(), LocalDateTime.now());

        importJob.setFilmsCount(result.getFilmsCount());
        importJob.setNewFilmsCount(result.getNewFilmsCount());
        importJob.setProcessingTime((int) processingTime.toSeconds());
        importJob.setStatusOfProcess(StatusOfProcess.SUCCESS);

        importJobRepository.save(importJob);
    }

    public void completeImportFailed(Long jobId) {
        ImportJob importJob = importJobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("ImportJob с id " + jobId + " не найден"));

        Duration processingTime = Duration.between(importJob.getStartTime(), LocalDateTime.now());

        importJob.setProcessingTime((int) processingTime.toSeconds());
        importJob.setStatusOfProcess(StatusOfProcess.FAILED);

        importJobRepository.save(importJob);
    }
}