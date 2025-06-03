package com.fiap.queimadas.monitoramentos.dto.sensor;

import com.fiap.queimadas.monitoramentos.domain.model.sensor.SensorTipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorRequestDTO {

    @NotBlank
    private String codigo;

    @NotNull
    private SensorTipo tipo;

    @NotNull
    private Boolean ativo;

    @NotNull
    private Long regiaoId;
}
