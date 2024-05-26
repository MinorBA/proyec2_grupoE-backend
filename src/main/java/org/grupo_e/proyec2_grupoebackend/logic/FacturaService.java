package org.grupo_e.proyec2_grupoebackend.logic;

import org.grupo_e.proyec2_grupoebackend.data.dto.FacturaDto;

import java.util.List;

public interface FacturaService {
    FacturaDto findFacturaById(long id);
    FacturaDto saveFactura(int emisorId, int clienteId, FacturaDto facturaDto);
    FacturaDto updateFactura(FacturaDto facturaDto);
    void deleteFactura(long id);
    List<FacturaDto> findAllFacturas();

    void generateXML(long id);
}
