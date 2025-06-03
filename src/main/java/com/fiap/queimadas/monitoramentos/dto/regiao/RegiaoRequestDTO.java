package com.fiap.queimadas.monitoramentos.dto.regiao;

import com.fiap.queimadas.monitoramentos.domain.model.regiao.RegiaoRisco;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegiaoRequestDTO {

    @NotBlank
    private String nome;

    @Enumerated(EnumType.STRING)
    @NotNull
    private RegiaoRisco risco;


    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;
}
