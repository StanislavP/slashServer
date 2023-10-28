package org.bugwriters.slashserver.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.bugwriters.slashserver.enums.ProductType;

@Entity
@Table(name = "products_types")
public class ProductTypeEntity extends BaseEntity{


    @Enumerated(value = EnumType.STRING)
    private ProductType productType;

    public ProductTypeEntity() {
    }

    public ProductType getProductType() {
        return productType;
    }

    public ProductTypeEntity setProductType(ProductType userRole) {
        this.productType = userRole;
        return this;
    }
}
