package com.fiap.queimadas.monitoramentos.mapper;

import com.fiap.queimadas.monitoramentos.domain.model.agenteAmbiental.AgenteAmbiental;
import com.fiap.queimadas.monitoramentos.domain.model.regiao.Regiao;
import com.fiap.queimadas.monitoramentos.dto.agenteAmbiental.*;

public class AgenteAmbientalMapper {

    public static AgenteAmbientalResponseDTO toDTO(AgenteAmbiental agente) {
        return new AgenteAmbientalResponseDTO(
                agente.getId(),
                agente.getNome(),
                agente.getMatricula(),
                agente.getRegiaoAtuacao() != null ? agente.getRegiaoAtuacao().getId() : null
        );
    }

    public static AgenteAmbiental toEntity(AgenteAmbientalRequestDTO dto, Regiao regiao) {
        return AgenteAmbiental.builder()
                .nome(dto.getNome())
                .matricula(dto.getMatricula())
                .regiaoAtuacao(regiao)
                .build();
    }
}
