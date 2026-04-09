package com.example.demo.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Treinos_entity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class TreinosEntity {

    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunosEntity alunos;

    @ManyToMany
    @JoinTable(
            name = "treinos_exercicios",
            joinColumns = @JoinColumn(name = "treino_id"),
            inverseJoinColumns = @JoinColumn(name = "exercicio_id")
    )
    private Set<ExerciciosEntity> exercicios = new HashSet<>();
}


