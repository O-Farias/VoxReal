package com.voxreal.controllers;

import com.voxreal.models.Opcao;
import com.voxreal.services.OpcaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opcoes")
public class OpcaoController {
    private final OpcaoService opcaoService;

    public OpcaoController(OpcaoService opcaoService) {
        this.opcaoService = opcaoService;
    }

    @GetMapping("/{votacaoId}")
    public ResponseEntity<List<Opcao>> listarOpcoes(@PathVariable Long votacaoId) {
        List<Opcao> opcoes = opcaoService.listarOpcoesPorVotacao(votacaoId);
        return ResponseEntity.ok(opcoes);
    }

    @PostMapping("/{votacaoId}")
    public ResponseEntity<Opcao> criarOpcao(@PathVariable Long votacaoId, @RequestBody String descricao) {
        Opcao opcao = opcaoService.criarOpcao(votacaoId, descricao);
        return ResponseEntity.ok(opcao);
    }

    @PostMapping("/{id}/votar")
    public ResponseEntity<Opcao> votarEmOpcao(@PathVariable Long id) {
        Opcao opcao = opcaoService.votarEmOpcao(id);
        return ResponseEntity.ok(opcao);
    }
}
