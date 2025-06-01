package com.fiap.queimadas.monitoramentos.service;

import com.fiap.queimadas.monitoramentos.domain.model.Regiao;
import com.fiap.queimadas.monitoramentos.repository.RegiaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegiaoService {

    private final RegiaoRepository repository;

    public RegiaoService(RegiaoRepository repository){
        this.repository = repository;
    }

    public List<Regiao> list() {
        return repository.findAll();
    }

    public Regiao save(Regiao regiao) {
        return repository.save(regiao);
    }
}
