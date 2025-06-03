package com.fiap.queimadas.monitoramentos.repository;

import com.fiap.queimadas.monitoramentos.domain.model.sensor.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
