package com.fiap.queimadas.monitoramentos.mapper;

import com.fiap.queimadas.monitoramentos.domain.model.regiao.Regiao;
import com.fiap.queimadas.monitoramentos.domain.model.sensor.Sensor;
import com.fiap.queimadas.monitoramentos.dto.sensor.SensorRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.sensor.SensorResponseDTO;

public class SensorMapper {

    public static Sensor toEntity(SensorRequestDTO dto, Regiao regiao){
        return Sensor.builder()
                .codigo(dto.getCodigo())
                .tipo(dto.getTipo())
                .ativo(dto.getAtivo())
                .regiao(regiao)
                .build();
    }

    public static SensorResponseDTO toDTO(Sensor entity){
        return new SensorResponseDTO(
                entity.getId(),
                entity.getCodigo(),
                entity.getTipo(),
                entity.getAtivo(),
                entity.getRegiao().getId()
        );
    }
}
