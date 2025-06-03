package com.fiap.queimadas.monitoramentos.controller;

import com.fiap.queimadas.monitoramentos.dto.FocoIncendio.FocoIncendioRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.FocoIncendio.FocoIncendioResponseDTO;
import com.fiap.queimadas.monitoramentos.service.FocoIncendioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/focos")
public class FocoIncendioController {

    private final FocoIncendioService service;

    public FocoIncendioController(FocoIncendioService service) {
        this.service = service;
    }

    @GetMapping
    public List<FocoIncendioResponseDTO> get() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FocoIncendioResponseDTO> getById(@PathVariable Long id) {
        FocoIncendioResponseDTO foco = service.getById(id);
        return ResponseEntity.ok(foco);
    }

    @PostMapping
    public ResponseEntity<FocoIncendioResponseDTO> save(@RequestBody @Valid FocoIncendioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FocoIncendioResponseDTO> update(@PathVariable Long id, @RequestBody @Valid FocoIncendioRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
