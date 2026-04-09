package com.example.demo.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Alunos_entity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class AlunosEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER) // o cascade faz as alteracoes em cascata
    @JoinColumn(name = "avaliacao_fisica_id")
    private AvaliacoesFisicasEntity avaliacoesFisicasEntity;


    @OneToMany(mappedBy = "alunos" , fetch = FetchType.LAZY)
    private Set<TreinosEntity> treinos = new HashSet<>();


}