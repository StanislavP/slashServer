package org.bugwriters.slashserver.models.response;

import lombok.Lombok;

import java.math.BigDecimal;

public class ProductResponse {

    Long id;
    String name;
    String description;
    BigDecimal price;
    BigDecimal duration;
    BigDecimal discount;
    String ownerName;
    String type;

    public ProductResponse() {
    }

    public String getType() {
        return type;
    }

    public ProductResponse setType(String type) {
        this.type = type;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ProductResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductResponse setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductResponse setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public ProductResponse setDuration(BigDecimal duration) {
        this.duration = duration;
        return this;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public ProductResponse setDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ProductResponse setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }
}
