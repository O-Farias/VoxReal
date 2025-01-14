package com.voxreal.services;

import com.voxreal.models.Votacao;
import com.voxreal.models.Status;
import com.voxreal.repositories.VotacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotacaoService {
    private final VotacaoRepository votacaoRepository;

    public VotacaoService(VotacaoRepository votacaoRepository) {
        this.votacaoRepository = votacaoRepository;
    }

    public List<Votacao> listarVotacoes() {
        return votacaoRepository.findAll();
    }

    public Votacao criarVotacao(String titulo) {
        Votacao votacao = new Votacao();
        votacao.setTitulo(titulo);
        votacao.setStatus(Status.ATIVA);
        return votacaoRepository.save(votacao);
    }

    public Optional<Votacao> buscarVotacaoPorId(Long id) {
        return votacaoRepository.findById(id);
    }

    public Votacao encerrarVotacao(Long id) {
        Optional<Votacao> votacaoOpt = votacaoRepository.findById(id);
        if (votacaoOpt.isPresent()) {
            Votacao votacao = votacaoOpt.get();
            votacao.setStatus(Status.ENCERRADA);
            return votacaoRepository.save(votacao);
        } else {
            throw new RuntimeException("Votação não encontrada.");
        }
    }
}
