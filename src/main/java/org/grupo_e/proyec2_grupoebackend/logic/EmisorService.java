package org.grupo_e.proyec2_grupoebackend.logic;

import org.grupo_e.proyec2_grupoebackend.data.dto.EmisorDto;

import java.util.List;

public interface EmisorService {
    EmisorDto findEmisorById(int id);
    EmisorDto saveEmisor(EmisorDto emisorDto);
    EmisorDto updateEmisor(EmisorDto emisorDto);
    void deleteEmisor(int id);
    List<EmisorDto> findAllEmisores();
}
