package com.fiap.queimadas.monitoramentos.repository;

import com.fiap.queimadas.monitoramentos.domain.model.regiao.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegiaoRepository extends JpaRepository<Regiao, Long> {
}
