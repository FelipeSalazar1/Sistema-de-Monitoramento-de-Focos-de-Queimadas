package com.fiap.queimadas.monitoramentos.dto.alerta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AlertaResponseDTO {
    private Long id;
    private LocalDateTime dataAlerta;
    private String status;
    private Long focoId;
    private Long agenteId;
}
