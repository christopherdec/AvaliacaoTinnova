package com.tinnova.cadastroveiculos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Veiculo> veiculos;
}
