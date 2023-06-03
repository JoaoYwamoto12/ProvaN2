package br.senac.go.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_sala")
public class Sala {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Integer id;

    private String nomeSala;
    private String nomeLocador;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Sala() {
    }
}
