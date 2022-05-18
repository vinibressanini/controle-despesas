package com.api.controledespesas.repository;

import com.api.controledespesas.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
