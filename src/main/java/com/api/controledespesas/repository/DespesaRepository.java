package com.api.controledespesas.repository;

import com.api.controledespesas.domain.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    
}
