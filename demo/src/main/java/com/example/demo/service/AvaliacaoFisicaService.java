package com.example.demo.service;


import com.example.demo.database.model.AlunosEntity;
import com.example.demo.database.model.AvaliacoesFisicasEntity;
import com.example.demo.database.repository.IAlunosRepository;
import com.example.demo.database.repository.IAvaliacoesRepository;
import com.example.demo.dto.AvaliacaoFisicaDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AvaliacaoFisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesRepository avaliacoesRepository;

public void criarAvaliacao(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
   AlunosEntity alunos = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
            .orElseThrow(() -> new NotFoundException("Aluno não encontrado:"));

    AvaliacoesFisicasEntity avaliacoesFisicasEntity = alunos.getAvaliacoesFisicasEntity();
    if (avaliacoesFisicasEntity != null) {
        throw new BadRequestException("Avaliação física já existe para este aluno");
    }

    avaliacoesFisicasEntity =  avaliacoesFisicasEntity.builder()
            .peso(avaliacaoFisicaDto.getPeso())
            .altura(avaliacaoFisicaDto.getAltura())
            .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPorcentagemGorduraCorporal())
            .build();

  // o cascade substitui avaliacoesFisicasEntity =  avaliacoesRepository.save(avaliacoesFisicasEntity);

    alunos.setAvaliacoesFisicasEntity(avaliacoesFisicasEntity);
    alunosRepository.save(alunos);


}

}
