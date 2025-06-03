package com.fiap.queimadas.monitoramentos.controller;

import com.fiap.queimadas.monitoramentos.dto.sensor.SensorRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.sensor.SensorResponseDTO;
import com.fiap.queimadas.monitoramentos.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @GetMapping
    public List<SensorResponseDTO> get() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> getById(@PathVariable Long id) {
        SensorResponseDTO sensor = service.getById(id);
        return ResponseEntity.ok(sensor);
    }

    @PostMapping
    public ResponseEntity<SensorResponseDTO> save(@RequestBody @Valid SensorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> update(@PathVariable Long id, @RequestBody @Valid SensorRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
