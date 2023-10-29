package org.bugwriters.slashserver.models.request;

import java.math.BigDecimal;

public class SellProducts {

    String productName;
    BigDecimal price;
    BigDecimal quantity;
    String ownerName;

    public SellProducts() {
    }

    public String getProductName() {
        return productName;
    }

    public SellProducts setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public SellProducts setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SellProducts setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public SellProducts setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }
}
