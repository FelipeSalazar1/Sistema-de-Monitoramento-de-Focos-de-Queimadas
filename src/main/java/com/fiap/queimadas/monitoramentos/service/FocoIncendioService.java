package com.fiap.queimadas.monitoramentos.service;

import com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio.FocoIncendio;
import com.fiap.queimadas.monitoramentos.domain.model.alerta.Alerta;
import com.fiap.queimadas.monitoramentos.dto.FocoIncendio.FocoIncendioRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.FocoIncendio.FocoIncendioResponseDTO;
import com.fiap.queimadas.monitoramentos.mapper.FocoIncendioMapper;
import com.fiap.queimadas.monitoramentos.repository.FocoIncendioRepository;
import com.fiap.queimadas.monitoramentos.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio.FocoSeveridade.GRAVE;

@Service
public class FocoIncendioService {

    private final FocoIncendioRepository focoRepository;
    private final SensorRepository sensorRepository;
    private final AlertaService alertaService;


    public FocoIncendioService(FocoIncendioRepository focoRepository, SensorRepository sensorRepository, AlertaService alertaService) {
        this.focoRepository = focoRepository;
        this.sensorRepository = sensorRepository;
        this.alertaService = alertaService;
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
        focoRepository.save(foco);

        if (foco.getSeveridade() == GRAVE) {
            alertaService.gerarAlertaParaFoco(foco);
        }
        return FocoIncendioMapper.toDTO(foco);
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
