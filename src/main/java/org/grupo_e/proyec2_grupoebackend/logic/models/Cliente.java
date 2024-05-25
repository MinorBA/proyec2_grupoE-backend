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
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceptor;
    private String nombre;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String telefono;
    private String correoElectronico;
    @ManyToOne
    @JoinColumn(name = "idEmisor", referencedColumnName = "idEmisor")
    private Emisor emisor;
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas = new ArrayList<>();
}
