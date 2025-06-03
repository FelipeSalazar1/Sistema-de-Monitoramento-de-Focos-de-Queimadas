package com.fiap.queimadas.monitoramentos.controller;

import com.fiap.queimadas.monitoramentos.dto.agenteAmbiental.AgenteAmbientalRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.agenteAmbiental.AgenteAmbientalResponseDTO;
import com.fiap.queimadas.monitoramentos.service.AgenteAmbientalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agentes")
public class AgenteAmbientalController {

    private final AgenteAmbientalService service;

    public AgenteAmbientalController(AgenteAmbientalService service) {
        this.service = service;
    }

    @GetMapping
    public List<AgenteAmbientalResponseDTO> listar() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenteAmbientalResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<AgenteAmbientalResponseDTO> salvar(@RequestBody @Valid AgenteAmbientalRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgenteAmbientalResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AgenteAmbientalRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
