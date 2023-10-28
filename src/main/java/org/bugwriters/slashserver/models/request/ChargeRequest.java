package org.bugwriters.slashserver.models.request;

import lombok.Data;

@Data
public class ChargeRequest {

    public enum Currency {
        EUR, USD;
    }
    private Long amount;
    private Currency currency;
}