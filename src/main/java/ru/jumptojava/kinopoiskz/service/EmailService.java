package ru.jumptojava.kinopoiskz.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendReport(String toEmail, String content, String format) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject("Отчёт по фильмам");
        helper.setText("Во вложении отчёт по фильмам в формате " + format);

        String filename = "films-report." + format;
        ByteArrayResource attachment = new ByteArrayResource(content.getBytes(StandardCharsets.UTF_8));
        helper.addAttachment(filename, attachment);

        javaMailSender.send(message);
    }
}
