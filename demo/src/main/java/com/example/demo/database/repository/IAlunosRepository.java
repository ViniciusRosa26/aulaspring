package com.example.demo.database.repository;

import com.example.demo.database.model.AlunosEntity;
import com.example.demo.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//  @Repository  nn precisa pq ta extends no repositiry

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {

    Optional<AlunosEntity> findByEmail(String email);

} 
