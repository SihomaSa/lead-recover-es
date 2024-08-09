package com.techqualitysolutions.leadrecover.shared.infrastructure.axon;

import com.techqualitysolutions.leadrecover.manageoffer.domain.model.aggregates.Offer;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AxonConfig {
    @Primary
    @Bean
    public Repository<Offer> offerEventSourcingRepository(EventStore eventStore) {
        return EventSourcingRepository.builder(Offer.class)
            .eventStore(eventStore)
            .build();
    }
}
