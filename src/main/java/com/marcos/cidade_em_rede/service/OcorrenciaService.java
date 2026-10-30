package com.marcos.cidade_em_rede.service;


import com.marcos.cidade_em_rede.entity.Ocorrencia;
import com.marcos.cidade_em_rede.enums.StatusOcorrencia;
import com.marcos.cidade_em_rede.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
}