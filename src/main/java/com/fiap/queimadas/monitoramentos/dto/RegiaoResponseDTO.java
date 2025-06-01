package com.fiap.queimadas.monitoramentos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegiaoResponseDTO {
    private Long id;
    private String nome;
    private String risco;
    private Double latitude;
    private Double longitude;
}
