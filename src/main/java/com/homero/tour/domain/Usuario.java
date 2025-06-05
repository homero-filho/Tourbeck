package com.homero.tour.domain;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;

    @Transient
    private String confirmaSenha;

    public Usuario(){}

    public Usuario(Long id, String nome, String senha, String confirmaSenha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}
