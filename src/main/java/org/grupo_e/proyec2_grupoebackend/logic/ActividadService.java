package org.grupo_e.proyec2_grupoebackend.logic;

import org.grupo_e.proyec2_grupoebackend.data.dto.ActividadDto;

import java.util.List;

public interface ActividadService {
    ActividadDto findActividadById(int id);
    ActividadDto saveActividad(int emisorId, ActividadDto actividadDto);
    ActividadDto updateActividad(ActividadDto actividadDto);
    void deleteActividad(int id);
    List<ActividadDto> findAllActividades();
}
