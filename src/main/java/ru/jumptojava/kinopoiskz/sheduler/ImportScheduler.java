package ru.jumptojava.kinopoiskz.sheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.jumptojava.kinopoiskz.entity.enums.ProcessType;
import ru.jumptojava.kinopoiskz.service.ImportJobService;

@Component
public class ImportScheduler {

    private final ImportJobService importJobService;

    public ImportScheduler(ImportJobService importJobService) {
        this.importJobService = importJobService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduledImport() {
        importJobService.submitImport(null, null, "YEAR", null,
                null, null, null, null,
                null, 1, null, ProcessType.SCHEDULED);
    }
}