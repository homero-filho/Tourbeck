package com.homero.tour.repository;

import com.homero.tour.domain.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {
    List<Avaliacao> findByLocalId(String localId);

}
