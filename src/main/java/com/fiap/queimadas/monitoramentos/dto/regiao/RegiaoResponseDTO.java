package com.fiap.queimadas.monitoramentos.dto.regiao;

import com.fiap.queimadas.monitoramentos.domain.model.regiao.RegiaoRisco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegiaoResponseDTO {
    private Long id;
    private String nome;
    private RegiaoRisco risco;
    private Double latitude;
    private Double longitude;
}
