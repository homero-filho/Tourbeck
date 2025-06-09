package com.homero.tour.controller;

import com.homero.tour.domain.Usuario;
import com.homero.tour.dto.LoginRequest;
import com.homero.tour.repository.UsuarioRepository;
import com.homero.tour.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> lista(){
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Usuario buscar (@PathVariable Long id){
        Usuario opcao = usuarioService.juninho(id);
        return opcao;
    }

    @PostMapping
    public Usuario insert(@RequestBody Usuario usuario){
        Usuario salvo = usuario;
        usuarioService.salvar(salvo);
        return salvo;
    }

    @PutMapping("/{id}")
    public Usuario atualizar (@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        usuarioService.deletar(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Usuario usuario = usuarioService.login(loginRequest.getEmail(), loginRequest.getSenha());

            return ResponseEntity.ok(usuario);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
