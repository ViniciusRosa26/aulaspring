package com.example.demo.database.model;

import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(name = "EXERCICIOS_ENTITY")
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder

    public class ExerciciosEntity {

        @Id
        @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private String nome;

        @Column(name = "grupo_muscular",nullable = false)
        private String grupoMuscular;




    }

