package br.senac.go.repositories;

import br.senac.go.domain.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    //List<Sala> findSalaByNomeLocadorLikeIgnoreCase(String nomeLocador);

}

