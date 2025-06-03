package com.fiap.queimadas.monitoramentos.mapper;

import com.fiap.queimadas.monitoramentos.domain.model.alerta.Alerta;
import com.fiap.queimadas.monitoramentos.dto.alerta.AlertaResponseDTO;

public class AlertaMapper {

    public static AlertaResponseDTO toDTO(Alerta alerta) {
        return new AlertaResponseDTO(
                alerta.getId(),
                alerta.getDataAlerta(),
                alerta.getStatus(),
                alerta.getFocoIncendio().getId(),
                alerta.getAgente() != null ? alerta.getAgente().getId() : null
        );
    }
}
