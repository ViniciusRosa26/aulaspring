package com.example.demo.database.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.math.BigDecimal;

@Entity
@Table(name = "avaliacoes_fisicas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class AvaliacoesFisicasEntity {

    @Id // chave primaria
    @GeneratedValue (strategy = GenerationType.IDENTITY) // auto incremento
    private Integer id;

    @Column(nullable = false) // faz a coluna peso sempre estar la, ela eh obrigatoria
    private BigDecimal peso;
    @Column(nullable = false)
    private BigDecimal altura;
    @Column(name = "porcentagem_gordura_corporal",nullable = false)
    private BigDecimal porcentagemGorduraCorporal;


}
