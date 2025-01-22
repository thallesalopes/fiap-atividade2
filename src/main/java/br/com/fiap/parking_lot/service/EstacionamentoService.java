package br.com.fiap.parking_lot.service;

import br.com.fiap.parking_lot.dto.EstacionamentoDTO;
import br.com.fiap.parking_lot.entities.Estacionamento;
import br.com.fiap.parking_lot.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Estacionamento entrarEstacionamento(String placa){
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.setPlaca(placa);
        estacionamento.setHoraEntrada(LocalDateTime.now());
        return estacionamentoRepository.save(estacionamento);
    }

    public Estacionamento sairEstacionamento(String placa){
        Estacionamento estacionamento = estacionamentoRepository.findByPlaca(placa);
        estacionamento.setHoraSaida(LocalDateTime.now());
        var tempoPermanencia = estacionamento.getHoraEntrada().until(estacionamento.getHoraSaida(), ChronoUnit.MINUTES);
        estacionamento.setTempoPermanencia(tempoPermanencia);
        return estacionamentoRepository.save(estacionamento);
    }

    public List<Estacionamento> consultarEstacionamento(){
        return estacionamentoRepository.findAll();
    }

    public Estacionamento consultarEstacionamento(String placa){
        return estacionamentoRepository.findByPlaca(placa);
    }

}
