package com.voxreal.services;

import com.voxreal.models.Opcao;
import com.voxreal.models.Votacao;
import com.voxreal.repositories.OpcaoRepository;
import com.voxreal.repositories.VotacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcaoService {
    private final OpcaoRepository opcaoRepository;
    private final VotacaoRepository votacaoRepository;

    public OpcaoService(OpcaoRepository opcaoRepository, VotacaoRepository votacaoRepository) {
        this.opcaoRepository = opcaoRepository;
        this.votacaoRepository = votacaoRepository;
    }

    public List<Opcao> listarOpcoesPorVotacao(Long votacaoId) {
        return opcaoRepository.findAllByVotacaoId(votacaoId);
    }

    public Opcao criarOpcao(Long votacaoId, String descricao) {
        Votacao votacao = votacaoRepository.findById(votacaoId)
                .orElseThrow(() -> new RuntimeException("Votação não encontrada."));
        Opcao opcao = new Opcao();
        opcao.setDescricao(descricao);
        opcao.setVotacao(votacao);
        return opcaoRepository.save(opcao);
    }

    public Opcao votarEmOpcao(Long opcaoId) {
        Opcao opcao = opcaoRepository.findById(opcaoId)
                .orElseThrow(() -> new RuntimeException("Opção não encontrada."));
        opcao.incrementarVotos();
        return opcaoRepository.save(opcao);
    }
}
