package com.fiap.queimadas.monitoramentos.service;

import com.fiap.queimadas.monitoramentos.domain.model.regiao.Regiao;
import com.fiap.queimadas.monitoramentos.dto.regiao.RegiaoRequestDTO;
import com.fiap.queimadas.monitoramentos.dto.regiao.RegiaoResponseDTO;
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

    public RegiaoResponseDTO findById(Long id) {
        Regiao regiao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Região não encontrada"));
        return new RegiaoResponseDTO(regiao.getId(), regiao.getNome(), regiao.getRisco(), regiao.getLatitude(), regiao.getLongitude());
    }

    public RegiaoResponseDTO update(Long id, RegiaoRequestDTO dto) {
        Regiao regiao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Região não encontrada"));
        regiao.setNome(dto.getNome());
        regiao.setRisco(dto.getRisco());
        regiao.setLatitude(dto.getLatitude());
        regiao.setLongitude(dto.getLongitude());
        regiao = repository.save(regiao);
        return new RegiaoResponseDTO(regiao.getId(), regiao.getNome(), regiao.getRisco(), regiao.getLatitude(), regiao.getLongitude());
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Região não encontrada");
        }
        repository.deleteById(id);
    }
}
