package com.clizan.offers.domain.model;

import java.math.BigDecimal;

public class CustomerContext {
    private String customerId;
    private BigDecimal monthlyIncome;
    private int creditScore;
    private boolean hasAccount;

    public CustomerContext() {}

    public CustomerContext(String customerId, BigDecimal monthlyIncome, int creditScore, boolean hasAccount) {
        this.customerId = customerId;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
        this.hasAccount = hasAccount;
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public BigDecimal getMonthlyIncome() { return monthlyIncome; }
    public void setMonthlyIncome(BigDecimal monthlyIncome) { this.monthlyIncome = monthlyIncome; }

    public int getCreditScore() { return creditScore; }
    public void setCreditScore(int creditScore) { this.creditScore = creditScore; }

    public boolean isHasAccount() { return hasAccount; }
    public void setHasAccount(boolean hasAccount) { this.hasAccount = hasAccount; }
}