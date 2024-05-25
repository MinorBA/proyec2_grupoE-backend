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
@Table(name = "emisores")
public class Emisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmisor;
    private String nombre;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private String correoElectronico;

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.REMOVE)
    private List<Cliente> clientes = new ArrayList<>();

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.REMOVE)
    private List<Factura> facturas = new ArrayList<>();

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.REMOVE)
    private List<Producto> productos = new ArrayList<>();

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.REMOVE)
    private List<Actividad> actividades = new ArrayList<>();
}