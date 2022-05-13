package com.desafio.wallet.service;

import com.desafio.wallet.dto.ContaDTO;
import com.desafio.wallet.entity.Usuario;
import com.desafio.wallet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RestTemplate client;



    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, RestTemplate client) {
        this.usuarioRepository = usuarioRepository;
        this.client = client;
    }

    public void cadastrar(Usuario usuarioEntity){

        usuarioRepository.save(usuarioEntity);
    }

    public void criarConta(ContaDTO contaDTO){
       client.postForEntity("http://localhost:8082/extrato/criarConta", contaDTO, String.class);
    }


}
