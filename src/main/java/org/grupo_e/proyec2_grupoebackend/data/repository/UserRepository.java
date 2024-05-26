package org.grupo_e.proyec2_grupoebackend.data.repository;


import org.grupo_e.proyec2_grupoebackend.logic.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
