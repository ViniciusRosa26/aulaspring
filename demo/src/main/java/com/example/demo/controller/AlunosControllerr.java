package com.example.demo.controller;


import com.example.demo.database.model.AvaliacoesFisicasEntity;
import com.example.demo.database.model.ExerciciosEntity;
import com.example.demo.dto.AlunoDto;
import com.example.demo.dto.ExercicioDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.AlunoService;
import com.example.demo.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated

public class AlunosControllerr {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@RequestBody @Valid AlunoDto alunoDto) throws BadRequestException {
        alunoService.criarAluno(alunoDto);
    }

    @GetMapping("/{alunoId}/avaliacao")
    public AvaliacoesFisicasEntity getAvaliacaoFIsica(@PathVariable Integer alunoId) throws BadRequestException {
        return alunoService.getAlunoAvaliacao(alunoId);
    }

}


