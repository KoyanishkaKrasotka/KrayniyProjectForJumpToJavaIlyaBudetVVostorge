package ru.jumptojava.kinopoiskz.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.dto.ImportMessage;

@Service
public class ImportProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ImportProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendImportMessage(ImportMessage importMessage) {

        kafkaTemplate.send("import-requests", importMessage);
    }
}
