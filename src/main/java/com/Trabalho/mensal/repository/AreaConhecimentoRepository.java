package com.Trabalho.mensal.repository;

import com.Trabalho.mensal.model.AreaConhecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaConhecimentoRepository extends JpaRepository<AreaConhecimento, Long> {
}
