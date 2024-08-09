package com.techqualitysolutions.leadrecover.publishoffer.domain.model.valueobjects;

public enum PublishStatus {
    SUBMITED(1),
    DISCARED(2),
    PUBLISH(3),
    UNPUBLISH(4);

    private int id;

    PublishStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
