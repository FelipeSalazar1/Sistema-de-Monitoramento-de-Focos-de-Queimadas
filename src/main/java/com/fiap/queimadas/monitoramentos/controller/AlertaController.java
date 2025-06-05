package com.fiap.queimadas.monitoramentos.controller;

import com.fiap.queimadas.monitoramentos.domain.model.alerta.Alerta;
import com.fiap.queimadas.monitoramentos.dto.alerta.AlertaResponseDTO;
import com.fiap.queimadas.monitoramentos.dto.alerta.AtribuirAgenteDTO;
import com.fiap.queimadas.monitoramentos.mapper.AlertaMapper;
import com.fiap.queimadas.monitoramentos.repository.AlertaRepository;
import com.fiap.queimadas.monitoramentos.service.AlertaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {
    private final AlertaRepository repository;
    private final AlertaService alertaService;

    public AlertaController(AlertaRepository repository, AlertaService alertaService) {
        this.repository = repository;
        this.alertaService = alertaService;
    }

    @GetMapping
    public List<AlertaResponseDTO> list() {
        return repository.findAll()
                .stream()
                .map(AlertaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}/atribuir-agente")
    public AlertaResponseDTO atribuirAgente(
            @PathVariable Long id,
            @RequestBody AtribuirAgenteDTO dto) {

        Alerta alerta = alertaService.atribuirAgente(id, dto.getAgenteId());
        return AlertaMapper.toDTO(alerta);
    }

    @PutMapping("/{id}/atualizar-status")
    public AlertaResponseDTO atualizarStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        Alerta alerta = alertaService.atualizarStatus(id, status);
        System.out.println(alerta.getStatus());

        return AlertaMapper.toDTO(alerta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Alerta não encontrado");
        }
        repository.deleteById(id);
    }
}
