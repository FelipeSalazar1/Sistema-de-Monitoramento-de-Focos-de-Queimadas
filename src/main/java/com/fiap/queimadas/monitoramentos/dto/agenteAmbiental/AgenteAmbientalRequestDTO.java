package com.fiap.queimadas.monitoramentos.dto.agenteAmbiental;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgenteAmbientalRequestDTO {
    private String nome;
    private String matricula;
    private Long regiaoAtuacaoId;
}
