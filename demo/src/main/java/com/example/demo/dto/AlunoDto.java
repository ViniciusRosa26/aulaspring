package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class AlunoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
}
