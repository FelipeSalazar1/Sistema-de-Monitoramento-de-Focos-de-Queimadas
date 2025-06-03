package com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio;

import com.fiap.queimadas.monitoramentos.domain.model.sensor.Sensor;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FocoIncendio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private FocoSeveridade severidade;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
}
