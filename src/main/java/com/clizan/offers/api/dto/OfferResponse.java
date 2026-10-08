package com.clizan.offers.api.dto;

import com.clizan.offers.domain.model.OfferType;
import java.math.BigDecimal;

public class OfferResponse {
    private String id;
    private String customerId;
    private OfferType type;
    private String description;
    private BigDecimal value;

    public OfferResponse() {}

    public OfferResponse(String id, String customerId, OfferType type, String description, BigDecimal value) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.description = description;
        this.value = value;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public OfferType getType() { return type; }
    public void setType(OfferType type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }
}