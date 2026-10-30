package com.marcos.cidade_em_rede.entity;

import com.marcos.cidade_em_rede.enums.StatusOcorrencia;
import com.marcos.cidade_em_rede.enums.CategoriaOcorrencia;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ocorrencias")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String protocolo;
    private String descricao;
    private Double latitude;
    private Double longitude;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private CategoriaOcorrencia categoria;

    @Enumerated(EnumType.STRING)
    private StatusOcorrencia status;

    public Ocorrencia() {

    }

    public Long getId() {
        return id;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo (String protocolo) {
        this.protocolo = protocolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude() {
        this.longitude = longitude;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public CategoriaOcorrencia getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaOcorrencia categoria) {
        this.categoria = categoria;
    }

    public StatusOcorrencia getStatus() {
        return status;
    }

    public void setStatus(StatusOcorrencia status) {
        this.status = status;
    }
}