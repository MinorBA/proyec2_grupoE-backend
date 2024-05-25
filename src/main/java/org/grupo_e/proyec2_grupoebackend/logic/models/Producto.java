package org.grupo_e.proyec2_grupoebackend.logic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String unidadMedida;
    @ManyToOne
    @JoinColumn(name = "idActividad", referencedColumnName = "idActividad")
    private Actividad actividad;
    @ManyToOne
    @JoinColumn(name = "idEmisor", referencedColumnName = "idEmisor")
    private Emisor emisor;
}
