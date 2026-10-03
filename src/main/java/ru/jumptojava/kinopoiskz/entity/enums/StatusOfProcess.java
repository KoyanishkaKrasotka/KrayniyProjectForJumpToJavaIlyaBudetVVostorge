package ru.jumptojava.kinopoiskz.entity.enums;

public enum StatusOfProcess {

    SUCCESS("SUCCESS"),
    IN_PROGRESS("IN_PROGRESS"),
    FAILED("FAILED");

    private final String valueOfStatus;

    StatusOfProcess(String valueOfStatus) {
        this.valueOfStatus = valueOfStatus;
    }

    public String getValueOfStatus() {
        return valueOfStatus;
    }
}
