package com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects;

public enum AnalyticStatus {

    SUCCESS(1),
    FAILED(2);

    private int id;

    AnalyticStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
