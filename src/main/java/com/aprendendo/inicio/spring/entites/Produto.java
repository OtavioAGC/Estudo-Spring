package com.aprendendo.inicio.spring.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private Long idProduto;
    @Column(name = "nome")
    private String nome;
    @Column(name = "marca")
    private String marca;
    @Column(name = "validade")
    private LocalDate validade;

}
