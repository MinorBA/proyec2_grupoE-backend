package org.grupo_e.proyec2_grupoebackend.logic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFactura;
    private String numeroFactura;
    @CreationTimestamp
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name = "idEmisor", referencedColumnName = "idEmisor")
    private Emisor emisor;
    @ManyToOne
    @JoinColumn(name = "idReceptor", referencedColumnName = "idReceptor")
    private Cliente cliente;

    public List<Producto> getProductos() {
        return emisor.getProductos();
    }


    public Double total(){
        double total = 0.0;
        for (Producto listProducto : getProductos())
            total += listProducto.getPrecio();
        return total;
    }
}
