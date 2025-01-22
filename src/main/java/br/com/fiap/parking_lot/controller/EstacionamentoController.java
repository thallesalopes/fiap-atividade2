package br.com.fiap.parking_lot.controller;

import br.com.fiap.parking_lot.entities.Estacionamento;
import br.com.fiap.parking_lot.service.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @GetMapping
    public ResponseEntity<List<Estacionamento>> buscarTodos(){
        var estacionamentos = estacionamentoService.consultarEstacionamento();
        return ResponseEntity.ok(estacionamentos);
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Estacionamento> buscarPorPlaca(String placa){
        var estacionamento = estacionamentoService.consultarEstacionamento(placa);
        return ResponseEntity.ok(estacionamento);
    }

    @PostMapping("/entrada")
    public ResponseEntity<Estacionamento> entrada(@RequestBody String placa){
        var estacionamento = estacionamentoService.entrarEstacionamento(placa);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(estacionamento);
    }

    @PostMapping("/saida")
    public ResponseEntity<Estacionamento> saida(@RequestBody String placa){
        var estacionamento = estacionamentoService.sairEstacionamento(placa);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(estacionamento);
    }





}
