package com.marcos.cidade_em_rede.service;


import com.marcos.cidade_em_rede.entity.Ocorrencia;
import com.marcos.cidade_em_rede.enums.StatusOcorrencia;
import com.marcos.cidade_em_rede.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository ocorrenciaRepository;

    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Ocorrencia registrarOcorrencia(Ocorrencia ocorrencia) {
        ocorrencia.setProtocolo(
                UUID.randomUUID().toString().replace("-", "").toUpperCase()
        );
        ocorrencia.setStatus(StatusOcorrencia.RECEBIDO);
        ocorrencia.setDataCriacao(LocalDateTime.now());
        return ocorrenciaRepository.save(ocorrencia);
    }

    public List<Ocorrencia> listarOcorrencias() {
        return ocorrenciaRepository.findAll();
    }

    public Optional<Ocorrencia> buscarPorId(Long id) {
        return ocorrenciaRepository.findById(id);
    }

    public Optional<Ocorrencia> atualizarPorId(Long id, Ocorrencia dadosAtualizados) {
        return ocorrenciaRepository.findById(id)
                .map(ocorrencia -> {
                    ocorrencia.setDescricao(dadosAtualizados.getDescricao());
                    ocorrencia.setCategoria(dadosAtualizados.getCategoria());
                    ocorrencia.setLatitude(dadosAtualizados.getLatitude());
                    ocorrencia.setLongitude(dadosAtualizados.getLongitude());

                    return ocorrenciaRepository.save(ocorrencia);
                });
    }

    public boolean deletarPorId(Long id) {
        if (!ocorrenciaRepository.existsById(id)) {
            return false;
        }
        ocorrenciaRepository.deleteById(id);
        return true;
    }
}