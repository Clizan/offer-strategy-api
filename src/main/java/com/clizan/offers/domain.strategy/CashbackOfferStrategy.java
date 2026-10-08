package com.clizan.offers.domain.strategy;

import com.clizan.offers.domain.model.CustomerContext;
import com.clizan.offers.domain.model.Offer;
import com.clizan.offers.domain.model.OfferType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class CashbackOfferStrategy implements OfferStrategy {

    @Override
    public boolean isApplicable(CustomerContext context) {
        return context.isHasAccount();
    }

    @Override
    public Offer generateOffer(CustomerContext context) {
        return new Offer(
                UUID.randomUUID().toString(),
                context.getCustomerId(),
                OfferType.CASHBACK,
                "Programa de Cashback de 2% em todas as compras",
                new BigDecimal("20.00")
        );
    }
}