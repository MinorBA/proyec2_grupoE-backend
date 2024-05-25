package org.grupo_e.proyec2_grupoebackend.logic;

import org.grupo_e.proyec2_grupoebackend.data.dto.ClienteDto;

import java.util.List;

public interface ClienteService {
    ClienteDto findClienteById(int id);
    ClienteDto saveCliente(int provedorId, ClienteDto clienteDto);
    ClienteDto updateCliente(ClienteDto clienteDto);
    void deleteCliente(int id);
    List<ClienteDto> findAllClientes();
}
