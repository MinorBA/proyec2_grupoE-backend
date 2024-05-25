package org.grupo_e.proyec2_grupoebackend.logic.services;

import org.grupo_e.proyec2_grupoebackend.data.dto.ClienteDto;
import org.grupo_e.proyec2_grupoebackend.data.mapper.ClienteMapper;
import org.grupo_e.proyec2_grupoebackend.data.repository.ClienteRepository;
import org.grupo_e.proyec2_grupoebackend.data.repository.EmisorRepository;
import org.grupo_e.proyec2_grupoebackend.logic.ClienteService;
import org.grupo_e.proyec2_grupoebackend.logic.models.Cliente;
import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {
    private ClienteRepository clienteRepository;
    private EmisorRepository emisorRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, EmisorRepository emisorRepository) {
        this.clienteRepository = clienteRepository;
        this.emisorRepository = emisorRepository;
    }

    @Override
    public ClienteDto findClienteById(int id) {
        Cliente cliente = clienteRepository.findById(id).get();
        return mapToClienteDto(cliente);
    }

    @Override
    public ClienteDto saveCliente(int emisorId, ClienteDto clienteDto) {
        Emisor emisor = emisorRepository.findById(emisorId).get();
        Cliente cliente = mapToCliente(clienteDto);
        cliente.setEmisor(emisor);
        Cliente savedCliente = clienteRepository.save(cliente);
        return mapToClienteDto(savedCliente);
    }

    @Override
    public ClienteDto updateCliente(ClienteDto clienteDto) {
        Cliente cliente = mapToCliente(clienteDto);
        Cliente updatedCliente = clienteRepository.save(cliente);
        return mapToClienteDto(updatedCliente);
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteDto> findAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(this::mapToClienteDto).collect(Collectors.toList());
    }

    private ClienteDto mapToClienteDto(Cliente cliente) {
        return ClienteMapper.mapToClienteDto(cliente);
    }

    private Cliente mapToCliente(ClienteDto clienteDto) {
        return ClienteMapper.mapToCliente(clienteDto);
    }
}
