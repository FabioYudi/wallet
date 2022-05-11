package com.desafio.wallet.service;

import com.desafio.wallet.entity.Usuario;
import com.desafio.wallet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrar(Usuario usuarioEntity){

        usuarioRepository.save(usuarioEntity);
    }


}
