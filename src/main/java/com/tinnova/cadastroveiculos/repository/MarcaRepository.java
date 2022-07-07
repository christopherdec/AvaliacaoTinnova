package com.tinnova.cadastroveiculos.repository;

import com.tinnova.cadastroveiculos.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    Marca findByNome(String nome);
}
