package com.fiap.queimadas.monitoramentos.service;

import com.fiap.queimadas.monitoramentos.domain.model.agenteAmbiental.AgenteAmbiental;
import com.fiap.queimadas.monitoramentos.dto.agenteAmbiental.*;
import com.fiap.queimadas.monitoramentos.dto.agenteAmbiental.AgenteAmbientalResponseDTO;
import com.fiap.queimadas.monitoramentos.mapper.AgenteAmbientalMapper;
import com.fiap.queimadas.monitoramentos.repository.AgenteAmbientalRepository;
import com.fiap.queimadas.monitoramentos.repository.RegiaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenteAmbientalService {

    private final AgenteAmbientalRepository agenteRepository;
    private final RegiaoRepository regiaoRepository;

    public AgenteAmbientalService(AgenteAmbientalRepository agenteRepository, RegiaoRepository regiaoRepository) {
        this.agenteRepository = agenteRepository;
        this.regiaoRepository = regiaoRepository;
    }

    public List<AgenteAmbientalResponseDTO> list() {
        return agenteRepository.findAll().stream()
                .map(AgenteAmbientalMapper::toDTO)
                .toList();
    }

    public AgenteAmbientalResponseDTO getById(Long id) {
        AgenteAmbiental agente = agenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agente não encontrado"));
        return AgenteAmbientalMapper.toDTO(agente);
    }

    public AgenteAmbientalResponseDTO save(AgenteAmbientalRequestDTO dto) {
        var regiao = regiaoRepository.findById(dto.getRegiaoAtuacaoId())
                .orElseThrow(() -> new IllegalArgumentException("Região de atuação não encontrada"));

        AgenteAmbiental agente = AgenteAmbientalMapper.toEntity(dto, regiao);
        return AgenteAmbientalMapper.toDTO(agenteRepository.save(agente));
    }

    public AgenteAmbientalResponseDTO update(Long id, AgenteAmbientalRequestDTO dto) {
        AgenteAmbiental agente = agenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agente não encontrado"));

        var regiao = regiaoRepository.findById(dto.getRegiaoAtuacaoId())
                .orElseThrow(() -> new IllegalArgumentException("Região de atuação não encontrada"));

        agente.setNome(dto.getNome());
        agente.setMatricula(dto.getMatricula());
        agente.setRegiaoAtuacao(regiao);

        return AgenteAmbientalMapper.toDTO(agenteRepository.save(agente));
    }

    public void delete(Long id) {
        if (!agenteRepository.existsById(id)) {
            throw new IllegalArgumentException("Agente não encontrado");
        }
        agenteRepository.deleteById(id);
    }
}
