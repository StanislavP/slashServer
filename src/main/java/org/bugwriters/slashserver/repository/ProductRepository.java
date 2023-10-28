package org.bugwriters.slashserver.repository;

import org.bugwriters.slashserver.models.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Override
    List<ProductEntity> findAll();
    ProductEntity findByName(String name);
//    ProductEntity findById(Long id);
    boolean existsByName(String name);
    boolean existsById(Long id);

    List<ProductEntity> findAllByUser_Email(String user_name);
}
