package ru.jumptojava.kinopoiskz.dto.enums;

public enum ReviewOrder {
    DATE_ASC("DATE_ASC"),
    DATE_DESC("DATE_DESC"),
    POSITIVE_RATING_ASC("USER_POSITIVE_RATING_ASC"),
    POSITIVE_RATING_DESC("USER_POSITIVE_RATING_DESC"),
    NEGATIVE_RATING_ASC("USER_NEGATIVE_RATING_ASC"),
    NEGATIVE_RATING_DESC("USER_NEGATIVE_RATING_DESC");

    private final String orderValue;

    ReviewOrder(String orderValue) {
        this.orderValue = orderValue;
    }

    public String getOrderValue() {
        return orderValue;
    }
}
