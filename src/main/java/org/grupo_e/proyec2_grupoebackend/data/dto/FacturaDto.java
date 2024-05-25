package org.grupo_e.proyec2_grupoebackend.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grupo_e.proyec2_grupoebackend.logic.models.Cliente;
import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;
import org.grupo_e.proyec2_grupoebackend.logic.models.Producto;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacturaDto {
    private long idFactura;
    @NotBlank(message = "El consecutivo no puede estar vacío")
    private String numeroFactura;
    @CreationTimestamp
    private LocalDateTime fecha;
    private Emisor emisor;
    private Cliente cliente;
    @NotNull(message = "La lista de productos no puede ser nula")
    private List<Producto> productos;
}
