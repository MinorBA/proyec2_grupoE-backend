package org.grupo_e.proyec2_grupoebackend.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grupo_e.proyec2_grupoebackend.logic.models.Actividad;
import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;
import org.grupo_e.proyec2_grupoebackend.logic.models.Factura;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDto {
    private int idProducto;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;
    @Min(value = 0, message = "El precio debe ser positivo")
    private Double precio;
    @NotBlank(message = "La unidad de medida no puede estar vacia")
    private String unidadMedida;
    @NotNull(message = "La actividad no puede ser nula")
    private Actividad actividad;
    private Emisor emisor;
}
