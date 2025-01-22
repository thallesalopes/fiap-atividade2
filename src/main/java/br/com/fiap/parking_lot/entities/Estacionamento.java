package br.com.fiap.parking_lot.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_estacionamento")
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String placa;

    @Column(name = "hora_de_entrada", nullable = false)
    private LocalDateTime horaEntrada;

    @Column(name ="hora_de_saida")
    private LocalDateTime horaSaida;

    @Column(name = "tempo_de_permanencia")
    private Long tempoPermanencia;

}
