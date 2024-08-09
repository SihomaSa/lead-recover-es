package com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects;

public enum Channel {
    SMS("S"), EMAIL("E");

    private String value;

    Channel(String value) {
        this.value = value;
    }

    public String getId() {
        return value;
    }
}
