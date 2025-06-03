package com.fiap.queimadas.monitoramentos.domain.model.alerta;

import com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio.FocoIncendio;
import com.fiap.queimadas.monitoramentos.domain.model.agenteAmbiental.AgenteAmbiental;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAlerta;

    private String status;

    @OneToOne
    @JoinColumn(name = "foco_id")
    private FocoIncendio focoIncendio;

    @ManyToOne
    @JoinColumn(name = "agente_id")
    private AgenteAmbiental agente;
}

