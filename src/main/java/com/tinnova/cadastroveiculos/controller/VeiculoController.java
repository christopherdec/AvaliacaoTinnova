package com.tinnova.cadastroveiculos.controller;

import com.tinnova.cadastroveiculos.model.Veiculo;
import com.tinnova.cadastroveiculos.repository.VeiculoRepository;
import com.tinnova.cadastroveiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;
    
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping()
    public List<Veiculo> buscar(@RequestParam(required = false) String marca,
                                @RequestParam(required = false) Integer ano,
                                @RequestParam(required = false) String cor) {
        return veiculoService.buscar(marca, ano, cor);
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<Veiculo> buscar(@PathVariable Long veiculoId) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(veiculoId);
        return veiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo adicionar(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }

    @PutMapping("/{veiculoId}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long veiculoId, @RequestBody Veiculo veiculo) {
        try {
            System.out.println(veiculo);
            veiculo = veiculoService.atualizar(veiculoId, veiculo);
            return ResponseEntity.ok(veiculo);

        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{veiculoId}")
    public ResponseEntity<Veiculo> atualizarParcial(@PathVariable Long veiculoId, @RequestBody Veiculo veiculo) {
        System.out.println(veiculo);
        return atualizar(veiculoId, veiculo);
    }

    @DeleteMapping("/{veiculoId}")
    public ResponseEntity<Veiculo> remover(@PathVariable Long veiculoId) {
            try {
                veiculoService.excluir(veiculoId);
                return ResponseEntity.noContent().build();

            } catch (DataIntegrityViolationException e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();

            } catch (EmptyResultDataAccessException e) {
                return ResponseEntity.notFound().build();
            }
    }

}
