package com.tinnova.cadastroveiculos.repository;

import com.tinnova.cadastroveiculos.model.Marca;
import com.tinnova.cadastroveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByMarca(Marca marca);
}
