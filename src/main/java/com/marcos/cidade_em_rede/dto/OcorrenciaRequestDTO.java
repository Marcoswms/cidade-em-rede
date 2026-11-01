package com.marcos.cidade_em_rede.dto;

import com.marcos.cidade_em_rede.enums.CategoriaOcorrencia;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OcorrenciaRequestDTO {

    @NotBlank(message = "A descrição da ocorrência é obrigatória.")
    private String descricao;

    @NotNull(message = "A categoria da ocorrência é obrigatória.")
    private CategoriaOcorrencia categoria;

    @NotNull(message = "A latitude é obrigatória.")
    @DecimalMin(value = "-90.0", message = "A latitude não pode ser menor que -90.")
    @DecimalMax(value = "90.0", message = "A latitude não pode ser maior que 90.")
    private Double latitude;

    @NotNull(message = "A longitude é obrigatória.")
    @DecimalMin(value = "-180.0", message = "A longitude não pode ser menor que -180.")
    @DecimalMax(value = "180.0", message = "A longitude não pode ser maior que 180.")
    private Double longitude;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaOcorrencia getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaOcorrencia categoria) {
        this.categoria = categoria;
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

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}