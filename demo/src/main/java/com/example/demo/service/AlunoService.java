package com.example.demo.service;


import com.example.demo.database.model.AlunosEntity;
import com.example.demo.database.model.AvaliacoesFisicasEntity;
import com.example.demo.database.repository.IAlunosRepository;
import com.example.demo.dto.AlunoDto;
import com.example.demo.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AlunoService {

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
}
