package com.fiap.queimadas.monitoramentos.repository;

import com.fiap.queimadas.monitoramentos.domain.model.FocoIncendio.FocoIncendio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FocoIncendioRepository extends JpaRepository<FocoIncendio, Long> {
}
