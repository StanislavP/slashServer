package org.bugwriters.slashserver.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.EphemeralKey;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.bugwriters.slashserver.models.request.ChargeRequest;
import org.bugwriters.slashserver.models.response.StripeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StripeService {

    @Value("${bugwriters.app.STRIPE_SECRET_KEY}")
    private String secretKey;
    @Value("${bugwriters.app.PUBLISHABLE_KEY}")
    private String publishableKey;


    @Autowired
     StripeService() {
        Stripe.apiKey = "sk_test_51O5pkdArrM9iT4QpflxHuNFtF65lgnqbtfR86KMXh1KxncKKFyzN3iAiTpRG67qzyXwK9tvv1ALwXwpLkI7A8gYR00EOlLLxNw";
    }

    public Customer createCustomer( String email ) throws Exception {
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", email);
        return Customer.create(customerParams);
    }
    public EphemeralKey createEphemeralKey( String id  ) throws Exception {
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("customer", id);
        customerParams.put("stripe-version", "2023-10-16");
        return EphemeralKey.create(customerParams);
    }
    private Customer getCustomer(String id) throws Exception {
        return Customer.retrieve(id);
    }
    public StripeResponse chargeNewCard(ChargeRequest chargeRequest) throws Exception {
        var customer = createCustomer("");
        var ephemeralKey = createEphemeralKey(customer.getId());


        PaymentIntent paymentIntent = new PaymentIntent();
        String clientSecret = "";
        try {
            PaymentIntent intent = PaymentIntent.create(new PaymentIntentCreateParams.Builder()
                    .setCurrency(chargeRequest.getCurrency().name()) // Set your desired currency
                    .setAmount(chargeRequest.getAmount()) // Set the payment amount in cents
                    .setCustomer(customer.getId())
                    .build());

            // Return the client secret to the frontend for use in the payment sheet
            clientSecret = intent.getClientSecret();
        } catch (Exception e) {
            e.printStackTrace();
        }


    return new StripeResponse().setEphemeralKey(ephemeralKey.getSecret()).setPublishableKey("pk_test_51O5pkdArrM9iT4QpZBIf1XIsTvnzV5dzy33ShQoanTivmxfPTon78yUTAgiz2W46zSluS3Xk9ilJIwWYxpTIGPMF00zpIUhhfQ").setCustomer(customer.getId()).setPaymentIntent(clientSecret);
    }




    public Charge charge(ChargeRequest chargeRequest) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        return Charge.create(chargeParams);
    }
}