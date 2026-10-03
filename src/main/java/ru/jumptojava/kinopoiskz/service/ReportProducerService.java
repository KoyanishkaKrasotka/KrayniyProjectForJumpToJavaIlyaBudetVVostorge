package ru.jumptojava.kinopoiskz.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.dto.ReportMessage;

@Service
public class ReportProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ReportProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendReportMessage(ReportMessage reportMessage) {

        kafkaTemplate.send("report-requests", reportMessage);
    }
}
