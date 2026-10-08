package com.clizan.offers.api;

import com.clizan.offers.api.dto.OfferRequest;
import com.clizan.offers.api.dto.OfferResponse;
import com.clizan.offers.application.OfferService;
import com.clizan.offers.domain.model.CustomerContext;
import com.clizan.offers.domain.model.Offer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping("/evaluate")
    public ResponseEntity<List<OfferResponse>> evaluateOffers(@RequestBody OfferRequest request) {
        CustomerContext context = new CustomerContext(
                request.getCustomerId(),
                request.getMonthlyIncome(),
                request.getCreditScore(),
                request.isHasAccount()
        );

        List<Offer> offers = offerService.generateAndSaveOffers(context);

        List<OfferResponse> response = offers.stream()
                .map(o -> new OfferResponse(o.getId(), o.getCustomerId(), o.getType(), o.getDescription(), o.getValue()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}