package org.bugwriters.slashserver.models.request;

import org.bugwriters.slashserver.enums.ProductType;

import java.math.BigDecimal;

public class ProductRequest {

    Long id;

    String name;

    String description;

    BigDecimal duration;

    BigDecimal price;

    String clientName;

    BigDecimal discount;

    ProductType productType;


    public ProductRequest() {
    }

    public Long getId() {
        return id;
    }

    public ProductRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public ProductRequest setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    public ProductRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductRequest setDescription(String description) {
        this.description = description;
        return this;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public ProductRequest setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getClientName() {
        return clientName;
    }

    public ProductRequest setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public ProductRequest setDuration(BigDecimal duration) {
        this.duration = duration;
        return this;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public ProductRequest setDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }
}
