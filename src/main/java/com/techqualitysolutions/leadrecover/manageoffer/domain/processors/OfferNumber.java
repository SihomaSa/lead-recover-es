package com.techqualitysolutions.leadrecover.manageoffer.domain.processors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OfferNumber {
    @Id
    public Long id;

    @Column(length=25, unique = true)
    public String number;

    public OfferNumber() {
    }

    public OfferNumber(Long id, String number) {
        this.id = id;
        this.number = number;
    }
}
