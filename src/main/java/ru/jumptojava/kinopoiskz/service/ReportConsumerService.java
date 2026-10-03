package ru.jumptojava.kinopoiskz.service;

import jakarta.mail.MessagingException;
import jakarta.xml.bind.JAXBException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.jumptojava.kinopoiskz.dto.ReportMessage;

import java.io.IOException;

@Component
public class ReportConsumerService {

    private final ReportService reportService;
    private final EmailService emailService;

    public ReportConsumerService(ReportService reportService, EmailService emailService) {
        this.reportService = reportService;
        this.emailService = emailService;
    }

    @KafkaListener(topics = "report-requests", groupId = "report-consumer-group")
    public void processReportMessage(ReportMessage reportMessage) {
        try {
            String content = reportService.generateReport(reportMessage.getFormat());
            emailService.sendReport(reportMessage.getEmail(), content, reportMessage.getFormat());
        } catch (JAXBException | IOException | MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
