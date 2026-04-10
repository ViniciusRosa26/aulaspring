package com.example.demo.database.repository;

import com.example.demo.database.model.AvaliacoesFisicasEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//  @Repository  nn precisa pq ta extends no repositiry

public interface IAvaliacoesRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {

    @Query(value = """
        SELECT a.id as idAluno,
               a.nome as nomeAluno,
               af.id as idAvaliacao,
               af.peso as peso,
               af.altura as altura,
               af.porcentagem_gordura_corporal as percentualGorduraCorporal
        FROM alunos_entity a
        INNER JOIN avaliacoes_fisicas af ON a.avaliacao_fisica_id = af.id
    """, nativeQuery = true)
    List<AvaliacoesFisicasProjection> getAllAvaliacoes();



    @Query(value = """
        SELECT a.id as idAluno,
               a.nome as nomeAluno,
               af.id as idAvaliacao,
               af.peso as peso,
               af.altura as altura,
               af.porcentagem_gordura_corporal as percentualGorduraCorporal
        FROM alunos_entity a
        INNER JOIN avaliacoes_fisicas af ON a.avaliacao_fisica_id = af.id
    """,
    countQuery = """
        SELECT COUNT(af.id)
        FROM alunos_entity a
        INNER JOIN avaliacoes_fisicas af ON a.avaliacao_fisica_id = af.id
    """,
    nativeQuery = true)
    Page<AvaliacoesFisicasProjection> getAllAvaliacoesPage(Pageable pageable);
}
