package org.grupo_e.proyec2_grupoebackend.data.repository;


import org.grupo_e.proyec2_grupoebackend.logic.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
