package com.marcos.cidade_em_rede.controller;


import com.marcos.cidade_em_rede.entity.Ocorrencia;
import com.marcos.cidade_em_rede.service.OcorrenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> listar() {
        List<Ocorrencia> ocorrencias = ocorrenciaService.listarOcorrencias();
        return ResponseEntity.ok(ocorrencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscarPorId(@PathVariable Long id) {
        return ocorrenciaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> atualizar(@PathVariable Long id, @RequestBody Ocorrencia dadosAtualizados) {
        return ocorrenciaService.atualizarPorId(id, dadosAtualizados)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = ocorrenciaService.deletarPorId(id);

        if (!deletado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}