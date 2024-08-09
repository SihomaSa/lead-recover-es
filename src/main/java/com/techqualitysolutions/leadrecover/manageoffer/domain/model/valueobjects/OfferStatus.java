package com.techqualitysolutions.leadrecover.manageoffer.domain.model.valueobjects;

public enum OfferStatus {
    STARTED(1),
    DELETED(2),
    COMPLETED(3);

    private int id;

    OfferStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
