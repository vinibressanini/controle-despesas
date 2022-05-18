package com.api.controledespesas.repository;

import com.api.controledespesas.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta,Long> {

}
