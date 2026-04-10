package com.example.demo.database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer"}) // para evitar erros de serializacao do hibernate

public class AvaliacoesFisicasEntity {

    @Id // chave primaria
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "avaliacao_seq")
    @SequenceGenerator(name = "avaliacao_seq", sequenceName = "avaliacao_sequence", allocationSize = 1)
    private Integer id;

    @Column(nullable = false) // faz a coluna peso sempre estar la, ela eh obrigatoria
    private BigDecimal peso;
    @Column(nullable = false)
    private BigDecimal altura;
    @Column(name = "porcentagem_gordura_corporal",nullable = false)
    private BigDecimal porcentagemGorduraCorporal;


}
