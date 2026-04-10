package com.example.demo.database.repository;

import java.math.BigDecimal;

public interface AvaliacoesFisicasProjection {
    Integer getIdAluno();
    String getNomeAluno();
    Integer getIdAvaliacao();
    BigDecimal getPeso();
    BigDecimal getAltura();
    BigDecimal getPercentualGorduraCorporal();
}

