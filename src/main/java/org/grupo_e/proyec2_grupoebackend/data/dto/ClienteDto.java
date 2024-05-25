package org.grupo_e.proyec2_grupoebackend.data.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;
import org.grupo_e.proyec2_grupoebackend.logic.models.Factura;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDto {
    private int idReceptor;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El tipo de identificación no puede estar vacío")
    private String tipoIdentificacion;

    @NotNull(message = "El número de identificación no puede ser nulo")
    @Size(min = 9, max = 12, message = "El número de identificación debe tener entre 9 y 12 dígitos")
    private String numeroIdentificacion;

    private String telefono;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico debe ser válido")
    private String correoElectronico;

    private Emisor emisor;
    private List<Factura> facturas = new ArrayList<>();
}
