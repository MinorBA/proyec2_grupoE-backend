package org.grupo_e.proyec2_grupoebackend.logic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "actividades")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActividad;
    private String descripcion;
    @OneToMany(mappedBy = "actividad")
    private List<Producto> productos;
    @ManyToOne
    @JoinColumn(name = "idEmisor", referencedColumnName = "idEmisor")
    private Emisor emisor;
}
