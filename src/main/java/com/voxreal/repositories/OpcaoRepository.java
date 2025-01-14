package com.voxreal.repositories;

import com.voxreal.models.Opcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpcaoRepository extends JpaRepository<Opcao, Long> {
    List<Opcao> findAllByVotacaoId(Long votacaoId);
}
