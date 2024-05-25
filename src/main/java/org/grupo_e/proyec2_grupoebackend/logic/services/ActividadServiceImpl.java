package org.grupo_e.proyec2_grupoebackend.logic.services;

import org.grupo_e.proyec2_grupoebackend.data.dto.ActividadDto;
import org.grupo_e.proyec2_grupoebackend.data.mapper.ActividadMapper;
import org.grupo_e.proyec2_grupoebackend.data.repository.ActividadRepository;
import org.grupo_e.proyec2_grupoebackend.data.repository.EmisorRepository;
import org.grupo_e.proyec2_grupoebackend.logic.ActividadService;
import org.grupo_e.proyec2_grupoebackend.logic.models.Actividad;
import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActividadServiceImpl implements ActividadService {
    private ActividadRepository actividadRepository;
    private EmisorRepository emisorRepository;

    @Autowired
    public ActividadServiceImpl(ActividadRepository actividadRepository, EmisorRepository emisorRepository) {
        this.actividadRepository = actividadRepository;
        this.emisorRepository = emisorRepository;
    }

    @Override
    public ActividadDto findActividadById(int id) {
        Actividad actividad = actividadRepository.findById(id).get();
        return mapToActividadDto(actividad);
    }

    @Override
    public ActividadDto saveActividad(int emisorId, ActividadDto actividadDto) {
        Emisor emisor = emisorRepository.findById(emisorId).get();
        Actividad actividad = mapToActividad(actividadDto);
        actividad.setEmisor(emisor);
        Actividad savedActividad = actividadRepository.save(actividad);
        return mapToActividadDto(savedActividad);
    }

    @Override
    public ActividadDto updateActividad(ActividadDto actividadDto) {
        Actividad actividad = mapToActividad(actividadDto);
        Actividad updatedActividad = actividadRepository.save(actividad);
        return mapToActividadDto(updatedActividad);
    }

    @Override
    public void deleteActividad(int id) {
        actividadRepository.deleteById(id);
    }

    @Override
    public List<ActividadDto> findAllActividades() {
        List<Actividad> actividades = actividadRepository.findAll();
        return actividades.stream().map(this::mapToActividadDto).collect(Collectors.toList());
    }

    private ActividadDto mapToActividadDto(Actividad actividad) {
        return ActividadMapper.mapToActividadDto(actividad);
    }

    private Actividad mapToActividad(ActividadDto actividadDto) {
        return ActividadMapper.mapToActividad(actividadDto);
    }
}
