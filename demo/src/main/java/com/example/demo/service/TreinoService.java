package com.example.demo.service;

import com.example.demo.database.model.AlunosEntity;
import com.example.demo.database.model.ExerciciosEntity;
import com.example.demo.database.model.TreinosEntity;
import com.example.demo.database.repository.IAlunosRepository;
import com.example.demo.database.repository.IExerciciosRepository;
import com.example.demo.database.repository.ITreinosRepository;
import com.example.demo.dto.TreinoDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {


  private final IAlunosRepository alunosRepository;
  private final IExerciciosRepository exerciciosRepository;
  private final ITreinosRepository treinosRepository;

  public void criarTreino(TreinoDto treinoDto) throws NotFoundException, BadRequestException {
      Set<ExerciciosEntity> exercicios = new HashSet<>();

      AlunosEntity aluno = alunosRepository.findById(treinoDto.getAlunoId())
              .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

      TreinosEntity treino = treinosRepository.findByNameAndAlunosId(treinoDto.getNome(), treinoDto.getAlunoId())
              .orElse(null );

      if (treino != null) {
          throw new BadRequestException("Treino já existe para este aluno");
      }

      for (Integer exercicioId : treinoDto.getExerciciosIds()) {

          ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                  .orElseThrow(() -> new NotFoundException(String.format("Exercício não encontrado: " ) + exercicioId));

          exercicios.add(exercicio);

          }

      treino = TreinosEntity.builder()
              .name(treinoDto.getNome())
              .alunos(aluno)
              .exercicios(exercicios)
              .build();

      treinosRepository.save(treino);
      }
  }

