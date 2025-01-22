package br.com.fiap.parking_lot.repository;

import br.com.fiap.parking_lot.entities.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, UUID> {
    Estacionamento findByPlaca(String placa);
}
