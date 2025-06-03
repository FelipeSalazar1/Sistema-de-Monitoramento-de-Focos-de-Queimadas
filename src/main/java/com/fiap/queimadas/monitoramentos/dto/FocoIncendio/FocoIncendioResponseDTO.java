package com.fiap.queimadas.monitoramentos.dto.FocoIncendio;

import com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio.FocoSeveridade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class FocoIncendioResponseDTO {

    private Long id;
    private LocalDateTime dataHora;
    private FocoSeveridade severidade;
    private Long sensorId;
}
