package com.homero.tour.service;

import com.homero.tour.domain.Usuario;
import com.homero.tour.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar(){
       List<Usuario> usuarios = usuarioRepository.findAll();
       return usuarios;
    }

    public Usuario juninho(Long id){
        Usuario opcao = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Não encontrado"));
        return opcao;
    }

    public Usuario salvar(Usuario usuario){
        Usuario salvo = usuario;
        usuarioRepository.save(salvo);
        return salvo;
    }

    public Usuario atualizar(Long id, Usuario usuarioNovo){
        Usuario usuarioBanco = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Não encontrado"));

        usuarioBanco.setNome(usuarioNovo.getNome());
        usuarioBanco.setSenha(usuarioNovo.getSenha());
        usuarioBanco.setConfirmaSenha(usuarioNovo.getConfirmaSenha());

        usuarioRepository.saveAndFlush(usuarioBanco);

        return usuarioBanco;
    }

    public void deletar(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }
    }
    public Usuario login(String email){
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (email == null){
            throw new RuntimeException("Usuário não encontrado");
        }

        return usuario;
    }
}
