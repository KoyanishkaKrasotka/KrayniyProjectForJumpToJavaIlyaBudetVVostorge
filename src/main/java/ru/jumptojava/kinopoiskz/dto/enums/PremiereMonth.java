package ru.jumptojava.kinopoiskz.dto.enums;

public enum PremiereMonth {

    JANUARY("JANUARY"),
    FEBRUARY("FEBRUARY"),
    MARCH("MARCH"),
    APRIL("APRIL"),
    MAY("MAY"),
    JUNE("JUNE"),
    JULY("JULY"),
    AUGUST("AUGUST"),
    SEPTEMBER("SEPTEMBER"),
    OCTOBER("OCTOBER"),
    NOVEMBER("NOVEMBER"),
    DECEMBER("DECEMBER");

    private final String monthValue;

    PremiereMonth(String monthValue) {
        this.monthValue = monthValue;
    }

    public String getMonthValue() {
        return monthValue;
    }
}
