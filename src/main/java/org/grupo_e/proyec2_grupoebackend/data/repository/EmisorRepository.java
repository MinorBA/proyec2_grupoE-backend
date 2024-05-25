package org.grupo_e.proyec2_grupoebackend.data.repository;


import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmisorRepository extends JpaRepository<Emisor, Integer> {

}
