package com.fiap.queimadas.monitoramentos.controller;

import com.fiap.queimadas.monitoramentos.dto.regiao.RegiaoRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.regiao.RegiaoResponseDTO;
import com.fiap.queimadas.monitoramentos.mapper.RegiaoMapper;
import com.fiap.queimadas.monitoramentos.service.RegiaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regioes")
public class RegiaoController {
    private final RegiaoService service;

    private RegiaoController(RegiaoService service){
        this.service = service;
    }

    @GetMapping
    public List<RegiaoResponseDTO> get() {
        return service.list().stream()
                .map(RegiaoMapper::toDTO)
                .toList();
    }

    @PostMapping
    public ResponseEntity<RegiaoResponseDTO> post(@RequestBody @Valid RegiaoRequestDTO dto){
        var regiao = RegiaoMapper.toEntity(dto);
        var saved = service.save(regiao);
        return ResponseEntity.status(HttpStatus.CREATED).body(RegiaoMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public RegiaoResponseDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public RegiaoResponseDTO update(@PathVariable Long id, @RequestBody RegiaoRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
