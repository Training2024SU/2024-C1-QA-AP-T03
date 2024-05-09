package com.davidbonelo.models.enums;

public enum Gender {
    MALE("gender-M"), FEMALE("gender-F"), OTHER("gender-I");

    private final String htmlId;

    Gender(String htmlId) {
        this.htmlId = htmlId;
    }

    public String getHtmlId() {
        return htmlId;
    }
}
