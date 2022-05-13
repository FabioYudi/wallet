package com.desafio.wallet.controller;

import com.desafio.wallet.dto.ContaDTO;
import com.desafio.wallet.facade.UsuarioInput;
import com.desafio.wallet.helper.ResponseHelper;
import com.desafio.wallet.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static com.desafio.wallet.constantes.UsuarioConstantes.MENSAGEM_SUCESSO_CADASTRO;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    private final UsuarioService usuarioService;


    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody UsuarioInput usuario){
        Random rand = new Random();
        String numeroConta = String.format("%04d", rand.nextInt(10000));
        usuarioService.cadastrar(usuario.toUsuarioEntity(numeroConta));
        usuarioService.criarConta(new ContaDTO(numeroConta));
        return ResponseHelper.Created(MENSAGEM_SUCESSO_CADASTRO);
    }
}
