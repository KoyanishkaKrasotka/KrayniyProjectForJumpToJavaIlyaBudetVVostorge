package ru.jumptojava.kinopoiskz.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.jumptojava.kinopoiskz.dto.ImportMessage;
import ru.jumptojava.kinopoiskz.dto.ImportResult;

@Component
public class ImportConsumerService {

    private final FilmService filmService;
    private final ImportJobService importJobService;

    public ImportConsumerService(FilmService filmService, ImportJobService importJobService) {
        this.filmService = filmService;
        this.importJobService = importJobService;
    }

    @KafkaListener(topics = "import-requests", groupId = "import-consumer-group")
    public void processImportMessage(ImportMessage importMessage) {
        try {
            ImportResult importResult = filmService.importFilmsWithStats(importMessage.getCountries(),importMessage.getGenres(), importMessage.getOrder(), importMessage.getType(), importMessage.getRatingFrom(), importMessage.getRatingTo(), importMessage.getYearFrom(), importMessage.getYearTo(), importMessage.getKeyword(), importMessage.getPage());
            importJobService.completeImportSuccess(importMessage.getJobId(), importResult);
        } catch (RuntimeException e) {
            importJobService.completeImportFailed(importMessage.getJobId());
        }
    }
}
