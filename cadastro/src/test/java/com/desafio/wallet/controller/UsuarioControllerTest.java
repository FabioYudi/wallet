package com.desafio.wallet.controller;

import com.desafio.wallet.facade.UsuarioInput;
import com.desafio.wallet.service.UsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    private static final String URL_CADASTRO = "/usuario/cadastrar";


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();

    }

    @Test
    void deve_cadastrar_com_sucesso() throws Exception {
        UsuarioInput usuarioInput = new UsuarioInput("Teste", "Teste@email");

        mockMvc.perform(MockMvcRequestBuilders.post(URL_CADASTRO)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(gerarUsuario(usuarioInput)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


    @Test
    void nao_deve_cadastrar_com_sucesso() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL_CADASTRO)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private String gerarUsuario(UsuarioInput usuarioInput) throws JsonProcessingException {
        return objectMapper.writeValueAsString(usuarioInput);
    }
}