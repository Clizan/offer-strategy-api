package com.clizan.offers.api.dto;

import java.math.BigDecimal;

public class OfferRequest {
    private String customerId;
    private BigDecimal monthlyIncome;
    private int creditScore;
    private boolean hasAccount;

    public OfferRequest() {}

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public BigDecimal getMonthlyIncome() { return monthlyIncome; }
    public void setMonthlyIncome(BigDecimal monthlyIncome) { this.monthlyIncome = monthlyIncome; }

    public int getCreditScore() { return creditScore; }
    public void setCreditScore(int creditScore) { this.creditScore = creditScore; }

    public boolean isHasAccount() { return hasAccount; }
    public void setHasAccount(boolean hasAccount) { this.hasAccount = hasAccount; }
}