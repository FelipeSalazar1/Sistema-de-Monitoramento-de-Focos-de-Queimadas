package com.fiap.queimadas.monitoramentos.dto.agenteAmbiental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AgenteAmbientalResponseDTO {
    private Long id;
    private String nome;
    private String matricula;
    private Long regiaoAtuacaoId;
}
