package org.bugwriters.slashserver.repository;

import org.bugwriters.slashserver.enums.UserRoles;
import org.bugwriters.slashserver.models.entity.RoleEntity;
import org.bugwriters.slashserver.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

     Boolean existsByEmail(String email);
     Optional<UserEntity> findByEmail(String userName);
//     List<UserEntity> findAllByRolesEquals(Set<RoleEntity> roles);
     Optional<UserEntity> findById(Long id);
}
