package org.grupo_e.proyec2_grupoebackend.data.mapper;

import org.grupo_e.proyec2_grupoebackend.data.dto.EmisorDto;
import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;

public class EmisorMapper {

    public static EmisorDto mapToEmisorDto(Emisor emisor) {
        return EmisorDto.builder()
                .idEmisor(emisor.getIdEmisor())
                .nombre(emisor.getNombre())
                .tipoIdentificacion(emisor.getTipoIdentificacion())
                .numeroIdentificacion(emisor.getNumeroIdentificacion())
                .nombreComercial(emisor.getNombreComercial())
                .direccion(emisor.getDireccion())
                .telefono(emisor.getTelefono())
                .correoElectronico(emisor.getCorreoElectronico())
                .clientes(emisor.getClientes())
                .facturas(emisor.getFacturas())
                .productos(emisor.getProductos())
                .actividades(emisor.getActividades())
                .build();
    }

    public static Emisor mapToEmisor(EmisorDto emisorDto) {
        return Emisor.builder()
                .idEmisor(emisorDto.getIdEmisor())
                .nombre(emisorDto.getNombre())
                .tipoIdentificacion(emisorDto.getTipoIdentificacion())
                .numeroIdentificacion(emisorDto.getNumeroIdentificacion())
                .nombreComercial(emisorDto.getNombreComercial())
                .direccion(emisorDto.getDireccion())
                .telefono(emisorDto.getTelefono())
                .correoElectronico(emisorDto.getCorreoElectronico())
                .clientes(emisorDto.getClientes())
                .facturas(emisorDto.getFacturas())
                .productos(emisorDto.getProductos())
                .actividades(emisorDto.getActividades())
                .build();
    }
}
