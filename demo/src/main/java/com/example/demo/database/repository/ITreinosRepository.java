package com.example.demo.database.repository;

import com.example.demo.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//  @Repository  nn precisa pq ta extends no repositiry

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {


}
