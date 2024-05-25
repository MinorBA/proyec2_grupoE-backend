package org.grupo_e.proyec2_grupoebackend.data.repository;

 import org.grupo_e.proyec2_grupoebackend.logic.models.Factura;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
