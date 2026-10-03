package ru.jumptojava.kinopoiskz.dto;

public class ReportMessage {

    private String email;

    private String format;

    public ReportMessage() {
    }

    public ReportMessage(String email, String format) {
        this.email = email;
        this.format = format;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
