package org.grupo_e.proyec2_grupoebackend.data.mapper;

import org.grupo_e.proyec2_grupoebackend.data.dto.ClienteDto;
import org.grupo_e.proyec2_grupoebackend.logic.models.Cliente;

public class ClienteMapper {

    public static ClienteDto mapToClienteDto(Cliente cliente) {
        return ClienteDto.builder()
                .idReceptor(cliente.getIdReceptor())
                .nombre(cliente.getNombre())
                .tipoIdentificacion(cliente.getTipoIdentificacion())
                .numeroIdentificacion(cliente.getNumeroIdentificacion())
                .telefono(cliente.getTelefono())
                .correoElectronico(cliente.getCorreoElectronico())
                .emisor(cliente.getEmisor())
                .facturas(cliente.getFacturas())
                .build();
    }

    public static Cliente mapToCliente(ClienteDto clienteDto) {
        return Cliente.builder()
                .idReceptor(clienteDto.getIdReceptor())
                .nombre(clienteDto.getNombre())
                .tipoIdentificacion(clienteDto.getTipoIdentificacion())
                .numeroIdentificacion(clienteDto.getNumeroIdentificacion())
                .telefono(clienteDto.getTelefono())
                .correoElectronico(clienteDto.getCorreoElectronico())
                .emisor(clienteDto.getEmisor())
                .facturas(clienteDto.getFacturas())
                .build();
    }
}
