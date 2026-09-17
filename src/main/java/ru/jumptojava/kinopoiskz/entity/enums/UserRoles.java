package ru.jumptojava.kinopoiskz.entity.enums;

public enum UserRoles {

    ADMIN("ADMIN"),
    USER("USER");

    private final String roleValue;

    UserRoles(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getRoleValue() {
        return roleValue;
    }
}
