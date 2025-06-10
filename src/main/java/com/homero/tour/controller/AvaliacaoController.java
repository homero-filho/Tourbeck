package com.homero.tour.controller;

import com.homero.tour.domain.Avaliacao;
import com.homero.tour.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<Avaliacao> criarAvaliacao(@Valid @RequestBody Avaliacao avaliacao) {
        Avaliacao novaAvaliacao = avaliacaoService.salvar(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.salvar(avaliacao));
    }

    /*
    @GetMapping
    public ResponseEntity<List<Avaliacao>> listarAvaliacoes() {
        return ResponseEntity.ok(avaliacaoService.listarTodas());
    }
     */

    //nuevos
    @GetMapping("/local/{localId}")
    public ResponseEntity<List<Avaliacao>> listarAvaliacoesPorLocal(@PathVariable String localId) {
        // Você precisará criar este método no seu AvaliacaoService
        List<Avaliacao> avaliacoes = avaliacaoService.listarPorLocal(localId);
        return ResponseEntity.ok(avaliacoes);
    }
}

