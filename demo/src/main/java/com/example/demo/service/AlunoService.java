package com.example.demo.service;


import com.example.demo.database.model.AlunosEntity;
import com.example.demo.database.model.AvaliacoesFisicasEntity;
import com.example.demo.database.repository.IAlunosRepository;
import com.example.demo.database.repository.IAvaliacoesRepository;
import com.example.demo.database.repository.ITreinosRepository;
import com.example.demo.dto.AlunoDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AlunoService {

    private final IAvaliacoesRepository avaliacoesRepository;
private final ITreinosRepository treinosRepository;
    private final IAlunosRepository alunosRepository;

    public void criarAluno(AlunoDto alunoDto) throws BadRequestException {
        AlunosEntity alunos = alunosRepository.findByEmail(alunoDto.getEmail()).orElse(null);

        if (alunos != null) {
            throw new BadRequestException("Email já cadastrado");
        }
        alunosRepository.save(AlunosEntity.builder()
                .nome(alunoDto.getNome())
                .email(alunoDto.getEmail())
                .build());
    }

    public AvaliacoesFisicasEntity getAlunoAvaliacao(Integer alunoId) throws BadRequestException {
        AlunosEntity alunos = alunosRepository.findById(alunoId)
                .orElseThrow(() -> new BadRequestException("Aluno não encontrado: " + alunoId));

        AvaliacoesFisicasEntity avaliacoesFisicasEntity = alunos.getAvaliacoesFisicasEntity();

        if (avaliacoesFisicasEntity == null) {
            throw new BadRequestException("Avaliação física não encontrada para o aluno: " );
        }

        return avaliacoesFisicasEntity;
    }
@Transactional // se der um erro entree as exclusoes ele da um roll back (n deixa perder as coisas excluidas antes)
    public void deletarAluno(Integer alunoId) throws NotFoundException{


AlunosEntity aluno = alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado: " + alunoId));

        //1 . deletar treinos

        List<Integer> treinosAlunoIds = aluno.getTreinos().stream()
                .map(treino -> treino.getId())
                .toList();

        treinosRepository.deleteAllById(treinosAlunoIds);
        //2 deledtar o aluno
        alunosRepository.deleteAllById(treinosAlunoIds);

        //3 deletar avaliacao
avaliacoesRepository.deleteById(aluno.getAvaliacoesFisicasEntity().getId());

    }
}
