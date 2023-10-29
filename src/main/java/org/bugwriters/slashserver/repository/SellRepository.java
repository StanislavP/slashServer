package org.bugwriters.slashserver.repository;

import org.bugwriters.slashserver.models.entity.SellEntity;
import org.bugwriters.slashserver.models.entity.UserEntity;
import org.bugwriters.slashserver.models.request.SellProducts;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface SellRepository extends JpaRepository<SellEntity,Long> {
    @Override
    Optional<SellEntity> findById(Long aLong);
}
