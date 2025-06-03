package com.fiap.queimadas.monitoramentos.domain.model.sensor;

import com.fiap.queimadas.monitoramentos.domain.model.regiao.Regiao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @Enumerated(EnumType.STRING)
    private SensorTipo tipo;

    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;
}
