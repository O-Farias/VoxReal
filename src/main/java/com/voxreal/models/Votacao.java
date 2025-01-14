package com.voxreal.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Votacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "votacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Opcao> opcoes = new ArrayList<>();

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Opcao> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<Opcao> opcoes) {
        this.opcoes = opcoes;
    }

    public void adicionarOpcao(Opcao opcao) {
        opcoes.add(opcao);
        opcao.setVotacao(this);
    }

    public void removerOpcao(Opcao opcao) {
        opcoes.remove(opcao);
        opcao.setVotacao(null);
    }
}
