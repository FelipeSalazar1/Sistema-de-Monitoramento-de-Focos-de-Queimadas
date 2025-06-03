package com.fiap.queimadas.monitoramentos.repository;

import com.fiap.queimadas.monitoramentos.domain.model.agenteAmbiental.AgenteAmbiental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteAmbientalRepository extends JpaRepository<AgenteAmbiental, Long> {
}
