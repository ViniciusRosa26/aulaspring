package com.example.demo.database.repository;

import com.example.demo.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//  @Repository  nn precisa pq ta extends no repositiry

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {


    Optional<TreinosEntity> findByNameAndAlunosId(String nome , Integer alunoId);
}
