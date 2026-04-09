package com.example.demo.service;

import com.example.demo.database.model.ExerciciosEntity;
import com.example.demo.database.repository.IExerciciosRepository;
import com.example.demo.dto.ExercicioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class ExerciciosService {

    private final IExerciciosRepository exerciciosRepository;
    
    public List<ExerciciosEntity> findAll(){
        return exerciciosRepository.findAll();
    }
    
public void save(ExercicioDto exercicioDto){
        exerciciosRepository.save(ExerciciosEntity.builder()
                .nome(exercicioDto.getNome())
                .grupoMuscular(exercicioDto.getGrupoMuscular())
                .build());
}
    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscularJPql(grupoMuscular);
    }

}
