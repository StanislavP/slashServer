package org.bugwriters.slashserver.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "sells")
public class SellEntity extends BaseEntity{

    @ManyToOne
    private ProductEntity product;

    @Column
    private BigDecimal price;

    @Column
    private BigDecimal quantity;

    public SellEntity() {
    }

    public ProductEntity getProduct() {
        return product;
    }

    public SellEntity setProduct(ProductEntity product) {
        this.product = product;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SellEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public SellEntity setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }
}
