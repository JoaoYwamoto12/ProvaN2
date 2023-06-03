package br.senac.go.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_reuniao")
public class Reuniao {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private LocalDateTime inicioHorario;
    private LocalDateTime fimReuniao;
    private String nomeReuniao;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    public Reuniao() {
    }
}
