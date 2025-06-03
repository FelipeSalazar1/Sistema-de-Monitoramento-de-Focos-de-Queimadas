package com.fiap.queimadas.monitoramentos.service;

import com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio.FocoIncendio;
import com.fiap.queimadas.monitoramentos.dto.FocoIncendio.FocoIncendioRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.FocoIncendio.FocoIncendioResponseDTO;
import com.fiap.queimadas.monitoramentos.mapper.FocoIncendioMapper;
import com.fiap.queimadas.monitoramentos.repository.FocoIncendioRepository;
import com.fiap.queimadas.monitoramentos.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FocoIncendioService {

    private final FocoIncendioRepository focoRepository;
    private final SensorRepository sensorRepository;

    public FocoIncendioService(FocoIncendioRepository focoRepository, SensorRepository sensorRepository) {
        this.focoRepository = focoRepository;
        this.sensorRepository = sensorRepository;
    }

    public List<FocoIncendioResponseDTO> list() {
        return focoRepository.findAll().stream()
                .map(FocoIncendioMapper::toDTO)
                .toList();
    }

    public FocoIncendioResponseDTO getById(Long id) {
        FocoIncendio foco = focoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Foco de incêndio não encontrado"));
        return FocoIncendioMapper.toDTO(foco);
    }

    public FocoIncendioResponseDTO save(FocoIncendioRequestDTO dto) {
        var sensor = sensorRepository.findById(dto.getSensorId())
                .orElseThrow(() -> new IllegalArgumentException("Sensor não encontrado"));

        FocoIncendio foco = FocoIncendioMapper.toEntity(dto, sensor);
        return FocoIncendioMapper.toDTO(focoRepository.save(foco));
    }

    public FocoIncendioResponseDTO update(Long id, FocoIncendioRequestDTO dto) {
        FocoIncendio foco = focoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Foco de incêndio não encontrado"));

        foco.setSeveridade(dto.getSeveridade());

        return FocoIncendioMapper.toDTO(focoRepository.save(foco));
    }

    public void delete(Long id) {
        if (!focoRepository.existsById(id)) {
            throw new IllegalArgumentException("Foco de incêndio não encontrado");
        }
        focoRepository.deleteById(id);
    }
}
