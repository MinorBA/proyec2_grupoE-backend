package org.grupo_e.proyec2_grupoebackend.presentation;
import jakarta.validation.Valid;
import org.grupo_e.proyec2_grupoebackend.data.dto.FacturaDto;
import org.grupo_e.proyec2_grupoebackend.logic.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    private final FacturaService facturaService;;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public ResponseEntity<List<FacturaDto>> listFacturas() {
        List<FacturaDto> facturaDtos = facturaService.findAllFacturas();
        return ResponseEntity.ok(facturaDtos);
    }

    @GetMapping("/{facturaId}")
    public ResponseEntity<FacturaDto> getFacturaById(@PathVariable long facturaId) {
        FacturaDto facturaDto = facturaService.findFacturaById(facturaId);
        if (facturaDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaDto);
    }

    @PostMapping("/emisor/{emisorId}/cliente/{clienteId}")
    public ResponseEntity<FacturaDto> createFactura(@PathVariable int emisorId, @PathVariable int clienteId, @Valid @RequestBody FacturaDto facturaDto) {
        FacturaDto savedFactura = facturaService.saveFactura(emisorId, clienteId, facturaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFactura);
    }

    @PutMapping("/{facturaId}")
    public ResponseEntity<FacturaDto> updateFactura(@PathVariable long facturaId, @Valid @RequestBody FacturaDto facturaDto) {
        FacturaDto existingFactura = facturaService.findFacturaById(facturaId);
        if (existingFactura == null) {
            return ResponseEntity.notFound().build();
        }
        facturaDto.setIdFactura(facturaId);
        FacturaDto updatedFactura = facturaService.updateFactura(facturaDto);
        return ResponseEntity.ok(updatedFactura);
    }

    @DeleteMapping("/{facturaId}")
    public ResponseEntity<Void> deleteFactura(@PathVariable long facturaId) {
        FacturaDto facturaDto = facturaService.findFacturaById(facturaId);
        if (facturaDto == null) {
            return ResponseEntity.notFound().build();
        }
        facturaService.deleteFactura(facturaId);
        return ResponseEntity.noContent().build();
    }
}
