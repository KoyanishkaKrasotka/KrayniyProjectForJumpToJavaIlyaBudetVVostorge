package ru.jumptojava.kinopoiskz.controller;

import jakarta.mail.MessagingException;
import jakarta.xml.bind.JAXBException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jumptojava.kinopoiskz.entity.Film;
import ru.jumptojava.kinopoiskz.repository.FilmRepository;
import ru.jumptojava.kinopoiskz.service.EmailService;
import ru.jumptojava.kinopoiskz.service.ReportService;

import java.util.List;

@RestController
public class ReportController {

    private final EmailService emailService;
    private final ReportService reportService;
    private final FilmRepository filmRepository;

    public ReportController(EmailService emailService, ReportService reportService, FilmRepository filmRepository) {
        this.emailService = emailService;
        this.reportService = reportService;
        this.filmRepository = filmRepository;
    }

    @GetMapping("/api/v2/films/report")
    public String sendReport(@RequestParam String email,
                             @RequestParam(defaultValue = "csv") String format) throws JAXBException, MessagingException {

        List<Film> films = filmRepository.findAll();

        String content = format.equals("xml")
                ? reportService.generateXml(films)
                : reportService.generateCsv(films);

        emailService.sendReport(email, content, format);

        return "Отчёт отправлен на " + email;
    }
}
