package com.voxreal.controllers;

import com.voxreal.models.Opcao;
import com.voxreal.services.OpcaoService;
import org.springframework.http.HttpStatus;
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

    // Endpoint para listar opções por votação
    @GetMapping("/votacao/{votacaoId}")
    public ResponseEntity<List<Opcao>> listarOpcoesPorVotacao(@PathVariable Long votacaoId) {
        List<Opcao> opcoes = opcaoService.listarOpcoesPorVotacao(votacaoId);
        return ResponseEntity.ok(opcoes);
    }

    // Endpoint para adicionar uma nova opção a uma votação
    @PostMapping("/votacao/{votacaoId}")
    public ResponseEntity<Opcao> adicionarOpcao(@PathVariable Long votacaoId, @RequestBody String descricao) {
        Opcao novaOpcao = opcaoService.adicionarOpcao(votacaoId, descricao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaOpcao);
    }

    // Endpoint para votar em uma opção
    @PostMapping("/{id}/votar")
    public ResponseEntity<Opcao> votarEmOpcao(@PathVariable Long id) {
        Opcao opcao = opcaoService.votarEmOpcao(id);
        return ResponseEntity.ok(opcao);
    }
}
