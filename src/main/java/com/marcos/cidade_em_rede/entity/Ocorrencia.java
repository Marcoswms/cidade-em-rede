package com.marcos.cidade_em_rede.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ocorrencias")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String protocolo;
    private Double descricao;
    private Double latitude;
    private Double longitude;
    private LocalDateTime dataCriacao;
}