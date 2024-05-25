package org.grupo_e.proyec2_grupoebackend.logic.services;

import org.grupo_e.proyec2_grupoebackend.data.dto.FacturaDto;
import org.grupo_e.proyec2_grupoebackend.data.mapper.FacturaMapper;
import org.grupo_e.proyec2_grupoebackend.data.repository.ClienteRepository;
import org.grupo_e.proyec2_grupoebackend.data.repository.EmisorRepository;
import org.grupo_e.proyec2_grupoebackend.data.repository.FacturaRepository;
import org.grupo_e.proyec2_grupoebackend.logic.FacturaService;
import org.grupo_e.proyec2_grupoebackend.logic.models.Cliente;
import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;
import org.grupo_e.proyec2_grupoebackend.logic.models.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaService {
    private FacturaRepository facturaRepository;
    private EmisorRepository emisorRepository;
    private ClienteRepository clienteRepository;

    @Autowired
    public FacturaServiceImpl(FacturaRepository facturaRepository, EmisorRepository emisorRepository, ClienteRepository clienteRepository) {
        this.facturaRepository = facturaRepository;
        this.emisorRepository = emisorRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public FacturaDto findFacturaById(long id) {
        Factura factura = facturaRepository.findById(id).get();
        return mapToFacturaDto(factura);
    }

    @Override
    public FacturaDto saveFactura(int emisorId, int clienteId, FacturaDto facturaDto) {
        Emisor emisor = emisorRepository.findById(emisorId).get();
        Cliente cliente = clienteRepository.findById(clienteId).get();
        Factura factura = mapToFactura(facturaDto);
        factura.setEmisor(emisor);
        factura.setCliente(cliente);
        Factura savedFactura = facturaRepository.save(factura);
        return mapToFacturaDto(savedFactura);
    }

    @Override
    public FacturaDto updateFactura(FacturaDto facturaDto) {
        Factura factura = mapToFactura(facturaDto);
        Factura updatedFactura = facturaRepository.save(factura);
        return mapToFacturaDto(updatedFactura);
    }

    @Override
    public void deleteFactura(long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public List<FacturaDto> findAllFacturas() {
        List<Factura> facturas = facturaRepository.findAll();
        return facturas.stream().map(this::mapToFacturaDto).collect(Collectors.toList());
    }

    private FacturaDto mapToFacturaDto(Factura factura) {
        return FacturaMapper.mapToFacturaDto(factura);
    }

    private Factura mapToFactura(FacturaDto facturaDto) {
        return FacturaMapper.mapToFactura(facturaDto);
    }
}
