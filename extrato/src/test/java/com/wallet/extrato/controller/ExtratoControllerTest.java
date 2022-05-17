package com.wallet.extrato.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.extrato.facade.ContaInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ExtratoControllerTest {

    private static final String URL_CONSULTAR_SALDO = "/extrato/saldo";
    private static final String URL_CONSULTAR_MOVIMENTACAO = "/extrato/movimentacao";
    private static final String URL_CRIAR_CONTA = "/extrato/criarConta";


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void nao_deve_consultarSaldo_conta_invalida() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(URL_CONSULTAR_SALDO)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("0000"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    void nao_deve_consultarMovimentacao_conta_invalida() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_CONSULTAR_MOVIMENTACAO)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("00"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void criarConta() throws Exception {
        ContaInput contaInput = new ContaInput("0000", BigDecimal.ZERO);
        mockMvc.perform(MockMvcRequestBuilders.post(URL_CRIAR_CONTA)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsBytes(contaInput)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}