package org.grupo_e.proyec2_grupoebackend.logic.services;

import org.grupo_e.proyec2_grupoebackend.data.dto.EmisorDto;
import org.grupo_e.proyec2_grupoebackend.data.mapper.EmisorMapper;
import org.grupo_e.proyec2_grupoebackend.data.repository.EmisorRepository;
import org.grupo_e.proyec2_grupoebackend.logic.EmisorService;
import org.grupo_e.proyec2_grupoebackend.logic.models.Emisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmisorServiceImpl implements EmisorService {
    private EmisorRepository emisorRepository;

    @Autowired
    public EmisorServiceImpl(EmisorRepository emisorRepository) {
        this.emisorRepository = emisorRepository;
    }

    @Override
    public EmisorDto findEmisorById(int id) {
        Emisor emisor = emisorRepository.findById(id).get();
        return mapToEmisorDto(emisor);
    }

    @Override
    public EmisorDto saveEmisor(EmisorDto emisorDto) {
        Emisor emisor = mapToEmisor(emisorDto);
        Emisor savedEmisor = emisorRepository.save(emisor);
        return mapToEmisorDto(savedEmisor);
    }

    @Override
    public EmisorDto updateEmisor(EmisorDto emisorDto) {
        Emisor emisor = mapToEmisor(emisorDto);
        Emisor updatedEmisor = emisorRepository.save(emisor);
        return mapToEmisorDto(updatedEmisor);
    }

    @Override
    public void deleteEmisor(int id) {
        emisorRepository.deleteById(id);
    }

    @Override
    public List<EmisorDto> findAllEmisores() {
        List<Emisor> emisores = emisorRepository.findAll();
        return emisores.stream().map(this::mapToEmisorDto).collect(Collectors.toList());
    }

    private EmisorDto mapToEmisorDto(Emisor emisor) {
        return EmisorMapper.mapToEmisorDto(emisor);
    }

    private Emisor mapToEmisor(EmisorDto emisorDto) {
        return EmisorMapper.mapToEmisor(emisorDto);
    }
}
