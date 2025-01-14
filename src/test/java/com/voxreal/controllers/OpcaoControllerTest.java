package com.voxreal.controllers;

import com.voxreal.models.Opcao;
import com.voxreal.services.OpcaoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OpcaoController.class)
public class OpcaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OpcaoService opcaoService;

    @Test
    void listarOpcoes_deveRetornarListaDeOpcoes() throws Exception {
        Opcao opcao1 = new Opcao();
        opcao1.setId(1L);
        opcao1.setNome("Opção 1");
        opcao1.setVotos(0);

        Opcao opcao2 = new Opcao();
        opcao2.setId(2L);
        opcao2.setNome("Opção 2");
        opcao2.setVotos(10);

        Mockito.when(opcaoService.listarOpcoesPorVotacao(anyLong()))
                .thenReturn(Arrays.asList(opcao1, opcao2));

        mockMvc.perform(get("/opcoes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nome").value("Opção 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nome").value("Opção 2"));
    }

    @Test
    void criarOpcao_deveRetornarOpcaoCriada() throws Exception {
        Opcao opcao = new Opcao();
        opcao.setId(1L);
        opcao.setNome("Nova Opção");
        opcao.setVotos(0);

        Mockito.when(opcaoService.criarOpcao(anyLong(), any(String.class)))
                .thenReturn(opcao);

        mockMvc.perform(post("/opcoes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\"Nova Opção\""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Nova Opção"));
    }

    @Test
    void votarEmOpcao_deveIncrementarVotos() throws Exception {
        Opcao opcao = new Opcao();
        opcao.setId(1L);
        opcao.setNome("Opção 1");
        opcao.setVotos(1);

        Mockito.when(opcaoService.votarEmOpcao(anyLong()))
                .thenReturn(opcao);

        mockMvc.perform(post("/opcoes/1/votar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.votos").value(1));
    }
}
