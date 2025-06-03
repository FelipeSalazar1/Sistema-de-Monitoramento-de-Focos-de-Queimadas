package com.fiap.queimadas.monitoramentos.repository;

import com.fiap.queimadas.monitoramentos.domain.model.alerta.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
