package com.marcos.cidade_em_rede.controller;


import com.marcos.cidade_em_rede.entity.Ocorrencia;
import com.marcos.cidade_em_rede.service.OcorrenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService ocorrenciaService;

    public OcorrenciaController(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> registrar(
            @RequestBody Ocorrencia ocorrencia) {

        Ocorrencia novaOcorrencia =
                ocorrenciaService.registrarOcorrencia(ocorrencia);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(novaOcorrencia);
    }
}