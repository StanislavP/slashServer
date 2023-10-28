package org.bugwriters.slashserver.models.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity{
    @Column(unique = true,nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal duration;

    @Column
    private BigDecimal discount;

    @Column
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProductTypeEntity productType;

    @ManyToOne
    private UserEntity user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public ProductEntity() {
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public ProductEntity setDuration(BigDecimal duration) {
        this.duration = duration;
        return this;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public ProductEntity setDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductTypeEntity getProductType() {
        return productType;
    }

    public ProductEntity setProductType(ProductTypeEntity productType) {
        this.productType = productType;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ProductEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public ProductEntity setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
