package ru.jumptojava.kinopoiskz.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jumptojava.kinopoiskz.dto.ReportMessage;
import ru.jumptojava.kinopoiskz.service.ReportProducerService;

@RestController
@Validated
public class ReportController {

    private final ReportProducerService reportProducerService;

    public ReportController(ReportProducerService reportProducerService) {
        this.reportProducerService = reportProducerService;
    }

    @GetMapping("/api/v2/films/report")
    public String sendReport(@RequestParam @Email String email,
                             @RequestParam(defaultValue = "csv") @Pattern(regexp = "csv|xml") String format) {

        ReportMessage reportMessage = new ReportMessage(email, format);
        reportProducerService.sendReportMessage(reportMessage);
        return "Запрос на отчёт принят, он будет отправлен на " + email;
    }
}
