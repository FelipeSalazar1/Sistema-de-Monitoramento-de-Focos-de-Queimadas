package com.fiap.queimadas.monitoramentos.domain.model.regiao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private RegiaoRisco risco;

    private Double latitude;
    private Double longitude;
}
