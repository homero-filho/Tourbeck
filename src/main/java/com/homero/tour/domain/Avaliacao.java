package com.homero.tour.domain;

import jakarta.persistence.*;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private int avaliacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
