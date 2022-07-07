package com.tinnova.cadastroveiculos.model;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String veiculo;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private String cor;

    @Column(columnDefinition="CHARACTER LARGE OBJECT")
    private String descricao;

    @Column(columnDefinition = "BOOLEAN default false")
    private boolean vendido;

    private LocalDateTime created;

    private LocalDateTime updated;
}
