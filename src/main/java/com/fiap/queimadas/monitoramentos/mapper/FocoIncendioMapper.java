package com.fiap.queimadas.monitoramentos.mapper;

import com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio.FocoIncendio;
import com.fiap.queimadas.monitoramentos.domain.model.sensor.Sensor;
import com.fiap.queimadas.monitoramentos.dto.FocoIncendio.FocoIncendioRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.FocoIncendio.FocoIncendioResponseDTO;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FocoIncendioMapper {

    public static FocoIncendio toEntity(FocoIncendioRequestDTO dto, Sensor sensor) {
        return FocoIncendio.builder()
                .dataHora(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime())
                .severidade(dto.getSeveridade())
                .sensor(sensor)
                .build();
    }

    public static FocoIncendioResponseDTO toDTO(FocoIncendio foco) {
        return new FocoIncendioResponseDTO(
                foco.getId(),
                foco.getDataHora(),
                foco.getSeveridade(),
                foco.getSensor().getId()
        );
    }
}
