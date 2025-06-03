package com.fiap.queimadas.monitoramentos.domain.model.agenteAmbiental;

import com.fiap.queimadas.monitoramentos.domain.model.regiao.Regiao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgenteAmbiental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String matricula;

    @ManyToOne
    @JoinColumn(name = "regiao_atuacao_id")
    private Regiao regiaoAtuacao;

}
