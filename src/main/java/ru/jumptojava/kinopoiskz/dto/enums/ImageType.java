package ru.jumptojava.kinopoiskz.dto.enums;

public enum ImageType {

    STILL("STILL"),
    SHOOTING("SHOOTING"),
    POSTER("POSTER"),
    FAN_ART("FAN_ART"),
    PROMO("PROMO"),
    CONCEPT("CONCEPT"),
    WALLPAPER("WALLPAPER"),
    COVER("COVER"),
    SCREENSHOT("SCREENSHOT");

    private final String typeValue;

    ImageType(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getTypeValue() {
        return typeValue;
    }
}
