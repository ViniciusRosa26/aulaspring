package com.example.demo.controller;


import com.example.demo.database.model.ExerciciosEntity;
import com.example.demo.dto.ExercicioDto;
import com.example.demo.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated

public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll(){
        return exerciciosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveExercicio(@Valid  @RequestBody ExercicioDto     exercicioDto){
        exerciciosService.save(exercicioDto);
    }

    @GetMapping ("/grupos/{grupoMuscular}")
    @ResponseStatus(HttpStatus.OK)
   public List<ExerciciosEntity> getExerciciosByGrupoMuscular(@PathVariable String grupoMuscular){
       return exerciciosService.getExerciciosByGrupoMuscular(grupoMuscular);


}

}
