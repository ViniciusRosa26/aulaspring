package com.example.demo.database.repository;

import com.example.demo.database.model.ExerciciosEntity;
import com.example.demo.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//  @Repository  nn precisa pq ta extends no repositiry

public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {

  // o de baixo substitui  List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

    // tbm pode usar o native query pra fzr igualzinho ta la banco

    @Query(value = "SELECT e FROM ExerciciosEntity e WHERE upper(e.grupoMuscular) = UPPER(:grupoMuscular) ")
    List<ExerciciosEntity> findAllByGrupoMuscularJPql(@Param("grupoMuscular") String grupoMuscular);
}
