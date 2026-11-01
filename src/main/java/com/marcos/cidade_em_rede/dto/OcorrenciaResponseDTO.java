package com.marcos.cidade_em_rede.dto;

import com.marcos.cidade_em_rede.entity.Ocorrencia;
import com.marcos.cidade_em_rede.enums.CategoriaOcorrencia;
import com.marcos.cidade_em_rede.enums.StatusOcorrencia;

import java.time.LocalDateTime;

public class OcorrenciaResponseDTO {

    private Long id;
    private String protocolo;
    private String descricao;
    private CategoriaOcorrencia categoria;
    private StatusOcorrencia status;
    private Double latitude;
    private Double longitude;
    private LocalDateTime dataCriacao;


    public OcorrenciaResponseDTO(Ocorrencia ocorrencia) {
        this.id = ocorrencia.getId();
        this.protocolo = ocorrencia.getProtocolo();
        this.descricao = ocorrencia.getDescricao();
        this.categoria = ocorrencia.getCategoria();
        this.status = ocorrencia.getStatus();
        this.latitude = ocorrencia.getLatitude();
        this.longitude = ocorrencia.getLongitude();
        this.dataCriacao = ocorrencia.getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public CategoriaOcorrencia getCategoria() {
        return categoria;
    }

    public StatusOcorrencia getStatus() {
        return status;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}