package org.bugwriters.slashserver.repository;

import org.bugwriters.slashserver.enums.UserRoles;
import org.bugwriters.slashserver.models.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByUserRole(UserRoles userRoles);
}
