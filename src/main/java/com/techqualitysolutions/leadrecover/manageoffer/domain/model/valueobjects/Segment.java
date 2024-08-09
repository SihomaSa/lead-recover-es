package com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects;

public enum Segment {
    LIGEROS("L"), PESADOS("P");

    private String value;

    Segment(String value) {
        this.value = value;
    }

    public String getId() {
        return value;
    }

}
