package com.clizan.offers.domain.strategy;

import com.clizan.offers.domain.model.CustomerContext;
import com.clizan.offers.domain.model.Offer;

public interface OfferStrategy {
    boolean isApplicable(CustomerContext context);
    Offer generateOffer(CustomerContext context);
}