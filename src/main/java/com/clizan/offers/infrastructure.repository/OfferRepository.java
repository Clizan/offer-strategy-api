package com.clizan.offers.infrastructure.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OfferRepository {
    private final ConcurrentHashMap<String, OfferDocument> storage = new ConcurrentHashMap<>();

    public OfferDocument save(OfferDocument document) {
        storage.put(document.getId(), document);
        return document;
    }

    public List<OfferDocument> findByCustomerId(String customerId) {
        List<OfferDocument> result = new ArrayList<>();
        for (OfferDocument doc : storage.values()) {
            if (doc.getCustomerId().equals(customerId)) {
                result.add(doc);
            }
        }
        return result;
    }
}