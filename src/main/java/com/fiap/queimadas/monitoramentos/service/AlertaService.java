package com.fiap.queimadas.monitoramentos.service;

import com.fiap.queimadas.monitoramentos.domain.model.agenteAmbiental.AgenteAmbiental;
import com.fiap.queimadas.monitoramentos.domain.model.alerta.Alerta;
import com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio.FocoIncendio;
import com.fiap.queimadas.monitoramentos.repository.AgenteAmbientalRepository;
import com.fiap.queimadas.monitoramentos.repository.AlertaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlertaService {

    private final AlertaRepository alertaRepository;
    private final AgenteAmbientalRepository agenteRepository;

    public AlertaService(AlertaRepository alertaRepository, AgenteAmbientalRepository agenteRepository) {
        this.alertaRepository = alertaRepository;
        this.agenteRepository = agenteRepository;
    }

    public Alerta gerarAlertaParaFoco(FocoIncendio foco) {
        Alerta alerta = Alerta.builder()
                .dataAlerta(LocalDateTime.now())
                .status("GERADO")
                .focoIncendio(foco)
                .build();

        return alertaRepository.save(alerta);
    }

    public Alerta atribuirAgente(Long alertaId, Long agenteId, String status) {
        Alerta alerta = alertaRepository.findById(alertaId)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));

        AgenteAmbiental agente = agenteRepository.findById(agenteId)
                .orElseThrow(() -> new RuntimeException("Agente não encontrado"));

        alerta.setAgente(agente);
        alerta.setStatus(status);

        return alertaRepository.save(alerta);
    }

    public Alerta atualizarStatus(Long alertaId,String status) {
        Alerta alerta = alertaRepository.findById(alertaId)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));

        alerta.setStatus(status);
        return alertaRepository.save(alerta);

    }

    public void delete(Long id) {
        if (!alertaRepository.existsById(id)) {
            throw new IllegalArgumentException("Alerta não encontrado");
        }
        alertaRepository.deleteById(id);
    }
}
