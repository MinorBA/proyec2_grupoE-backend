package org.grupo_e.proyec2_grupoebackend.presentation;

import org.grupo_e.proyec2_grupoebackend.data.dto.ActividadDto;
import org.grupo_e.proyec2_grupoebackend.data.dto.EmisorDto;
import org.grupo_e.proyec2_grupoebackend.logic.ActividadService;
import org.grupo_e.proyec2_grupoebackend.logic.EmisorService;
import org.grupo_e.proyec2_grupoebackend.logic.models.Actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {
    private final ActividadService actividadService;
    private final EmisorService emisorService;

    @Autowired
    public ActividadController(ActividadService actividadService, EmisorService emisorService) {
        this.actividadService = actividadService;
        this.emisorService = emisorService;
    }

    @GetMapping
    public ResponseEntity<List<ActividadDto>> listActividades() {
        List<ActividadDto> actividadDtos = actividadService.findAllActividades();
        return ResponseEntity.ok(actividadDtos);
    }

    @GetMapping("/{actividadId}")
    public ResponseEntity<ActividadDto> getActividadById(@PathVariable int actividadId) {
        ActividadDto actividadDto = actividadService.findActividadById(actividadId);
        if (actividadDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actividadDto);
    }

    @GetMapping("/emisor/{emisorId}")
    public ResponseEntity<List<Actividad>> listActividadesByEmisor(@PathVariable int emisorId) {
        EmisorDto emisorrDto = emisorService.findEmisorById(emisorId);
        if (emisorrDto == null) {
            return ResponseEntity.notFound().build();
        }
        List<Actividad> actividades = emisorrDto.getActividades();
        return ResponseEntity.ok(actividades);
    }


    @PostMapping("/emisor/{emisorId}")
    public ResponseEntity<ActividadDto> createActividad(@PathVariable int emisorId, @Valid @RequestBody ActividadDto actividadDto) {
        ActividadDto savedActividad = actividadService.saveActividad(emisorId, actividadDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedActividad);
    }

    @PutMapping("/{actividadId}")
    public ResponseEntity<ActividadDto> updateActividad(@PathVariable int actividadId, @Valid @RequestBody ActividadDto actividadDto) {
        ActividadDto existingActividad = actividadService.findActividadById(actividadId);
        if (existingActividad == null) {
            return ResponseEntity.notFound().build();
        }
        actividadDto.setIdActividad(actividadId);
        actividadDto.setEmisor(existingActividad.getEmisor());
        ActividadDto updatedActividad = actividadService.updateActividad(actividadDto);
        return ResponseEntity.ok(updatedActividad);
    }

    @DeleteMapping("/{actividadId}")
    public ResponseEntity<Void> deleteActividad(@PathVariable int actividadId) {
        ActividadDto actividadDto = actividadService.findActividadById(actividadId);
        if (actividadDto == null) {
            return ResponseEntity.notFound().build();
        }
        actividadService.deleteActividad(actividadId);
        return ResponseEntity.noContent().build();
    }
}
