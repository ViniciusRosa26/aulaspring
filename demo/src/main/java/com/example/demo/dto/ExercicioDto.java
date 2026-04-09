package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class ExercicioDto {

    @NotBlank(message = "O nome do exercício e o grupo são obrigatório")
    private String nome;
    private String grupoMuscular;
}
