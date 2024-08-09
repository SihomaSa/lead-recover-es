package com.techqualitysolutions.leadrecover.improvepersonalization.domain.model.valueobjects;

public enum CampaignStatus {

    SUCCESS(1),
    FAILED(2);

    private int id;

    CampaignStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
