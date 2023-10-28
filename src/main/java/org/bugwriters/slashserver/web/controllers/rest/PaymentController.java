package org.bugwriters.slashserver.web.controllers.rest;

import jakarta.validation.Valid;
import org.bugwriters.slashserver.models.request.ChargeRequest;
import org.bugwriters.slashserver.models.response.StripeResponse;
import org.bugwriters.slashserver.services.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final StripeService stripeService;

    @Autowired
    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/charge")
    public ResponseEntity< StripeResponse > chargeCreditCard(@Valid @RequestBody ChargeRequest chargeRequest) {
        try {
            StripeResponse response = stripeService.chargeNewCard(chargeRequest);
            return ResponseEntity.ok()
                    .body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StripeResponse());
        }
    }

}
