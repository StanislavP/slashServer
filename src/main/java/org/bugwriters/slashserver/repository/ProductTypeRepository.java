package org.bugwriters.slashserver.repository;

import org.bugwriters.slashserver.enums.ProductType;
import org.bugwriters.slashserver.models.entity.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity,Long> {

    Optional<ProductTypeEntity> findByProductType(ProductType productType );
}
