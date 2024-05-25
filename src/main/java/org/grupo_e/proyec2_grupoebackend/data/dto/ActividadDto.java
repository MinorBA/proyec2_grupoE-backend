package org.grupo_e.proyec2_grupoebackend.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;
import org.grupo_e.proyec2_grupoebackend.logic.models.Producto;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActividadDto {
    @NotEmpty(message = "El codigo no puede ser nulo")
    private int idActividad;
    @NotBlank(message = "La descripcion no puede estar vacía")
    private String descripcion;
    private List<Producto> productos = new ArrayList<>();
    private Emisor emisor;

}
