package com.clizan.offers.domain.strategy;

import com.clizan.offers.domain.model.CustomerContext;
import com.clizan.offers.domain.model.Offer;
import com.clizan.offers.domain.model.OfferType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class CreditOfferStrategy implements OfferStrategy {

    @Override
    public boolean isApplicable(CustomerContext context) {
        return context.getCreditScore() >= 700 && context.getMonthlyIncome().compareTo(new BigDecimal("3000")) >= 0;
    }

    @Override
    public Offer generateOffer(CustomerContext context) {
        BigDecimal limit = context.getMonthlyIncome().multiply(new BigDecimal("2.5"));
        return new Offer(
                UUID.randomUUID().toString(),
                context.getCustomerId(),
                OfferType.CREDIT,
                "Pré-aprovação de Cartão de Crédito com Limite Especial",
                limit
        );
    }
}