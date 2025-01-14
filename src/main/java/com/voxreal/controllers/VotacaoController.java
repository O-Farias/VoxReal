package com.voxreal.controllers;

import com.voxreal.models.Votacao;
import com.voxreal.services.VotacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votacoes")
public class VotacaoController {
    private final VotacaoService votacaoService;

    public VotacaoController(VotacaoService votacaoService) {
        this.votacaoService = votacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Votacao>> listarVotacoes() {
        List<Votacao> votacoes = votacaoService.listarVotacoes();
        return ResponseEntity.ok(votacoes);
    }

    @PostMapping
    public ResponseEntity<Votacao> criarVotacao(@RequestBody String titulo) {
        Votacao votacao = votacaoService.criarVotacao(titulo);
        return ResponseEntity.ok(votacao);
    }

    @PutMapping("/{id}/encerrar")
    public ResponseEntity<Votacao> encerrarVotacao(@PathVariable Long id) {
        Votacao votacao = votacaoService.encerrarVotacao(id);
        return ResponseEntity.ok(votacao);
    }
}
