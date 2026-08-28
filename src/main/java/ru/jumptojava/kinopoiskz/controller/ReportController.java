package ru.jumptojava.kinopoiskz.controller;

import jakarta.mail.MessagingException;
import jakarta.xml.bind.JAXBException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jumptojava.kinopoiskz.service.EmailService;
import ru.jumptojava.kinopoiskz.service.ReportService;

import java.io.IOException;

@RestController
public class ReportController {

    private final EmailService emailService;
    private final ReportService reportService;

    public ReportController(EmailService emailService, ReportService reportService) {
        this.emailService = emailService;
        this.reportService = reportService;
    }

    @GetMapping("/api/v2/films/report")
    public String sendReport(@RequestParam String email,
                             @RequestParam(defaultValue = "csv") String format) throws JAXBException, MessagingException, IOException {



        String content = reportService.generateReport(format);
        emailService.sendReport(email, content, format);

        return "Отчёт отправлен на " + email;
    }
}
