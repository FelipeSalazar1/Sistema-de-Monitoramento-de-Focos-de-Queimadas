package com.fiap.queimadas.monitoramentos.dto.FocoIncendio;

import com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio.FocoSeveridade;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FocoIncendioRequestDTO {

    @NotNull
    private FocoSeveridade severidade;

    @NotNull
    private Long sensorId;
}
