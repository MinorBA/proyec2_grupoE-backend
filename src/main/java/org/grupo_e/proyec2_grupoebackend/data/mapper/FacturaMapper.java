package org.grupo_e.proyec2_grupoebackend.data.mapper;

import org.grupo_e.proyec2_grupoebackend.data.dto.FacturaDto;
import org.grupo_e.proyec2_grupoebackend.logic.models.Factura;

public class FacturaMapper {

    public static FacturaDto mapToFacturaDto(Factura factura) {
        return FacturaDto.builder()
                .idFactura(factura.getIdFactura())
                .numeroFactura(factura.getNumeroFactura())
                .fecha(factura.getFecha())
                .emisor(factura.getEmisor())
                .cliente(factura.getCliente())
                .build();
    }

    public static Factura mapToFactura(FacturaDto facturaDto) {
        return Factura.builder()
                .idFactura(facturaDto.getIdFactura())
                .numeroFactura(facturaDto.getNumeroFactura())
                .fecha(facturaDto.getFecha())
                .emisor(facturaDto.getEmisor())
                .cliente(facturaDto.getCliente())
                .build();
    }
}

