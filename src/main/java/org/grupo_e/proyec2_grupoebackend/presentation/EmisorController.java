package org.grupo_e.proyec2_grupoebackend.presentation;

import jakarta.validation.Valid;
import org.grupo_e.proyec2_grupoebackend.data.dto.EmisorDto;
import org.grupo_e.proyec2_grupoebackend.logic.EmisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emisores")
public class EmisorController {
    private final EmisorService emisorService;

    @Autowired
    public EmisorController(EmisorService emisorService) {
        this.emisorService = emisorService;
    }

    @GetMapping
    public ResponseEntity<List<EmisorDto>> listEmisores() {
        List<EmisorDto> emisorDtos = emisorService.findAllEmisores();
        return ResponseEntity.ok(emisorDtos);
    }

    @GetMapping("/{emisorId}")
    public ResponseEntity<EmisorDto> getEmisorById(@PathVariable int emisorId) {
        EmisorDto emisorDto = emisorService.findEmisorById(emisorId);
        if (emisorDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emisorDto);
    }

    @PostMapping
    public ResponseEntity<EmisorDto> createEmisor(@Valid @RequestBody EmisorDto emisorDto) {
        EmisorDto savedEmisor = emisorService.saveEmisor(emisorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmisor);
    }

    @PutMapping("/{emisorId}")
    public ResponseEntity<EmisorDto> updateEmisor(@PathVariable int emisorId, @Valid @RequestBody EmisorDto emisorDto) {
        EmisorDto existingEmisor = emisorService.findEmisorById(emisorId);
        if (existingEmisor == null) {
            return ResponseEntity.notFound().build();
        }
        emisorDto.setIdEmisor(emisorId);
        EmisorDto updatedEmisor = emisorService.updateEmisor(emisorDto);
        return ResponseEntity.ok(updatedEmisor);
    }

    @DeleteMapping("/{emisorId}")
    public ResponseEntity<Void> deleteEmisor(@PathVariable int emisorId) {
        EmisorDto emisorDto = emisorService.findEmisorById(emisorId);
        if (emisorDto == null) {
            return ResponseEntity.notFound().build();
        }
        emisorService.deleteEmisor(emisorId);
        return ResponseEntity.noContent().build();
    }
}

