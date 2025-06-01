package com.fiap.queimadas.monitoramentos.mapper;

import com.fiap.queimadas.monitoramentos.domain.model.Regiao;
import com.fiap.queimadas.monitoramentos.dto.RegiaoRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.RegiaoResponseDTO;

public class RegiaoMapper {

    public static Regiao toEntity(RegiaoRequestDTO dto) {
        return Regiao.builder()
                .nome(dto.getNome())
                .risco(dto.getRisco())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
    }

    public static RegiaoResponseDTO toDTO(Regiao entity) {
        return new RegiaoResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getRisco(),
                entity.getLatitude(),
                entity.getLongitude()
        );
    }
}
