package com.contasapi.contas.repository;

import com.contasapi.contas.model.Conta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
