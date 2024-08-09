package com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects;

public enum Source {
    POS("P"), ECOMMERCE("E");

    private String value;

    Source(String value) {
        this.value = value;
    }

    public String getId() {
        return value;
    }
}
