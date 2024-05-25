package org.grupo_e.proyec2_grupoebackend.data.repository;


import org.grupo_e.proyec2_grupoebackend.logic.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
    UserEntity findFirstByUsername(String username);
}
