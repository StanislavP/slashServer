package org.bugwriters.slashserver.models.response;

public class StripeResponse {

    private String paymentIntent;
    private String ephemeralKey;
    private String customer;
    private String publishableKey;


    public StripeResponse() {
    }

    public String getPaymentIntent() {
        return paymentIntent;
    }

    public StripeResponse setPaymentIntent(String paymentIntent) {
        this.paymentIntent = paymentIntent;
        return this;
    }

    public String getEphemeralKey() {
        return ephemeralKey;
    }

    public StripeResponse setEphemeralKey(String ephemeralKey) {
        this.ephemeralKey = ephemeralKey;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public StripeResponse setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getPublishableKey() {
        return publishableKey;
    }

    public StripeResponse setPublishableKey(String publishableKey) {
        this.publishableKey = publishableKey;
        return this;
    }
}
