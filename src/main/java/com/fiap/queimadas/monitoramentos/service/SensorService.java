package com.fiap.queimadas.monitoramentos.service;

import com.fiap.queimadas.monitoramentos.domain.model.sensor.Sensor;
import com.fiap.queimadas.monitoramentos.dto.sensor.SensorRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.sensor.SensorResponseDTO;
import com.fiap.queimadas.monitoramentos.mapper.SensorMapper;
import com.fiap.queimadas.monitoramentos.repository.RegiaoRepository;
import com.fiap.queimadas.monitoramentos.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;
    private final RegiaoRepository regiaoRepository;

    public SensorService(SensorRepository sensorRepository, RegiaoRepository regiaoRepository) {
        this.sensorRepository = sensorRepository;
        this.regiaoRepository = regiaoRepository;
    }

    public List<SensorResponseDTO> list() {
        return sensorRepository.findAll().stream()
                .map(SensorMapper::toDTO)
                .toList();
    }

    public SensorResponseDTO getById(Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sensor não encontrado"));
        return SensorMapper.toDTO(sensor);
    }

    public SensorResponseDTO save(SensorRequestDTO dto) {
        var regiao = regiaoRepository.findById(dto.getRegiaoId())
                .orElseThrow(() -> new IllegalArgumentException("Região não encontrada"));

        Sensor sensor = SensorMapper.toEntity(dto, regiao);
        return SensorMapper.toDTO(sensorRepository.save(sensor));
    }

    public SensorResponseDTO update(Long id, SensorRequestDTO dto) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sensor não encontrado"));

        sensor.setAtivo(dto.getAtivo());

        return SensorMapper.toDTO(sensorRepository.save(sensor));
    }

    public void delete(Long id) {
        if (!sensorRepository.existsById(id)) {
            throw new IllegalArgumentException("Sensor não encontrado");
        }
        sensorRepository.deleteById(id);
    }
}
