package com.clizan.offers.application;

import com.clizan.offers.domain.model.CustomerContext;
import com.clizan.offers.domain.model.Offer;
import com.clizan.offers.domain.strategy.OfferStrategy;
import com.clizan.offers.infrastructure.repository.OfferDocument;
import com.clizan.offers.infrastructure.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferService {

    private final List<OfferStrategy> strategies;
    private final OfferRepository repository;

    public OfferService(List<OfferStrategy> strategies, OfferRepository repository) {
        this.strategies = strategies;
        this.repository = repository;
    }

    public List<Offer> generateAndSaveOffers(CustomerContext context) {
        List<Offer> generatedOffers = new ArrayList<>();

        for (OfferStrategy strategy : strategies) {
            if (strategy.isApplicable(context)) {
                Offer offer = strategy.generateOffer(context);
                generatedOffers.add(offer);

                OfferDocument doc = new OfferDocument(
                        offer.getId(),
                        offer.getCustomerId(),
                        offer.getType(),
                        offer.getDescription(),
                        offer.getValue()
                );
                repository.save(doc);
            }
        }

        return generatedOffers;
    }
}