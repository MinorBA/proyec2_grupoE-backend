package org.grupo_e.proyec2_grupoebackend.data.mapper;

import org.grupo_e.proyec2_grupoebackend.data.dto.ActividadDto;
import org.grupo_e.proyec2_grupoebackend.logic.models.Actividad;

public class ActividadMapper {

    public static ActividadDto mapToActividadDto(Actividad actividad) {
        return ActividadDto.builder()
                .idActividad(actividad.getIdActividad())
                .descripcion(actividad.getDescripcion())
                .productos(actividad.getProductos())
                .emisor(actividad.getEmisor())
                .build();
    }

    public static Actividad mapToActividad(ActividadDto actividadDto) {
        return Actividad.builder()
                .idActividad(actividadDto.getIdActividad())
                .descripcion(actividadDto.getDescripcion())
                .productos(actividadDto.getProductos())
                .emisor(actividadDto.getEmisor())
                .build();
    }
}
