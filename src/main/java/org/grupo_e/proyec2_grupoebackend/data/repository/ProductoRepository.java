package org.grupo_e.proyec2_grupoebackend.data.repository;

import org.grupo_e.proyec2_grupoebackend.logic.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
