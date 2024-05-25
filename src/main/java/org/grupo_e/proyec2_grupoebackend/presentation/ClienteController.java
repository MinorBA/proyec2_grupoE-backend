package org.grupo_e.proyec2_grupoebackend.presentation;

import jakarta.validation.Valid;
import org.grupo_e.proyec2_grupoebackend.data.dto.ClienteDto;
import org.grupo_e.proyec2_grupoebackend.data.dto.EmisorDto;
import org.grupo_e.proyec2_grupoebackend.logic.ClienteService;
import org.grupo_e.proyec2_grupoebackend.logic.EmisorService;
import org.grupo_e.proyec2_grupoebackend.logic.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    private final EmisorService emisorService;

    @Autowired
    public ClienteController(ClienteService clienteService, EmisorService emisorService) {
        this.clienteService = clienteService;
        this.emisorService = emisorService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listClientes() {
        List<ClienteDto> clienteDtos = clienteService.findAllClientes();
        return ResponseEntity.ok(clienteDtos);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable int clienteId) {
        ClienteDto clienteDto = clienteService.findClienteById(clienteId);
        if (clienteDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDto);
    }

    @GetMapping("/emisor/{emisorId}")
    public ResponseEntity<List<Cliente>> listClientesByEmisor(@PathVariable int emisorId) {
        EmisorDto emisorDto = emisorService.findEmisorById(emisorId);
        if (emisorDto == null) {
            return ResponseEntity.notFound().build();
        }
        List<Cliente> clientes = emisorDto.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/emisor/{emisorId}")
    public ResponseEntity<ClienteDto> createCliente(@PathVariable int emisorId, @Valid @RequestBody ClienteDto clienteDto) {
        ClienteDto savedCliente = clienteService.saveCliente(emisorId, clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable int clienteId, @Valid @RequestBody ClienteDto clienteDto) {
        ClienteDto existingCliente = clienteService.findClienteById(clienteId);
        if (existingCliente == null) {
            return ResponseEntity.notFound().build();
        }
        clienteDto.setIdReceptor(clienteId);
        clienteDto.setEmisor(existingCliente.getEmisor());
        ClienteDto updatedCliente = clienteService.updateCliente(clienteDto);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int clienteId) {
        ClienteDto clienteDto = clienteService.findClienteById(clienteId);
        if (clienteDto == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteCliente(clienteId);
        return ResponseEntity.noContent().build();
    }
}

