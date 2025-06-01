package com.fiap.queimadas.monitoramentos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegiaoRequestDTO {

    @NotBlank
    private String nome;

    private String risco;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;
}
