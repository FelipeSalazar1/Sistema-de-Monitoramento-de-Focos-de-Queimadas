package com.fiap.queimadas.monitoramentos.dto.sensor;

import com.fiap.queimadas.monitoramentos.domain.model.sensor.SensorTipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SensorResponseDTO {

    private Long Id;
    private String codigo;
    private SensorTipo tipo;
    private Boolean ativo;
    private Long regiaoId;
}
