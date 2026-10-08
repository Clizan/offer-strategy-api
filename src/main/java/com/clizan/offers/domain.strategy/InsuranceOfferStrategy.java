package com.clizan.offers.domain.strategy;

import com.clizan.offers.domain.model.CustomerContext;
import com.clizan.offers.domain.model.Offer;
import com.clizan.offers.domain.model.OfferType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class InsuranceOfferStrategy implements OfferStrategy {

    @Override
    public boolean isApplicable(CustomerContext context) {
        return context.isHasAccount() && context.getCreditScore() >= 500;
    }

    @Override
    public Offer generateOffer(CustomerContext context) {
        return new Offer(
                UUID.randomUUID().toString(),
                context.getCustomerId(),
                OfferType.INSURANCE,
                "Seguro de Vida com Desconto para Correntistas",
                new BigDecimal("50.00")
        );
    }
}