package org.grupo_e.proyec2_grupoebackend.data.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grupo_e.proyec2_grupoebackend.logic.models.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmisorDto {
    private int idEmisor;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "El tipo de identificación no puede estar vacío")
    private String tipoIdentificacion;
    @NotNull(message = "El número de identificación no puede ser nulo")
    @Size(min = 9, max = 12, message = "El número de identificación debe tener entre 9 y 12 dígitos")
    private String numeroIdentificacion;
    @NotBlank(message = "El nombre del comercial no puede estar vacío")
    private String nombreComercial;
    @NotBlank(message = "La direccion no puede estar vacíoa")
    private String direccion;
    @NotBlank(message = "El telefono no puede estar vacío")
    private String telefono;
    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico debe ser válido")
    private String correoElectronico;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Factura> facturas = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Actividad> actividades = new ArrayList<>();
}
