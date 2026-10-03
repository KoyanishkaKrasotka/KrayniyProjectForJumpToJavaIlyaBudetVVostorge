package ru.jumptojava.kinopoiskz.entity.enums;

public enum ProcessType {

    MANUAL("MANUAL"),
    SCHEDULED("SCHEDULED");

    private final String valueOfType;

    ProcessType(String valueOfType) {
        this.valueOfType = valueOfType;
    }

    public String getValueOfType() {
        return valueOfType;
    }
}
