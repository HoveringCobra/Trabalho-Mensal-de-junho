package com.Trabalho.mensal.repository;

import com.Trabalho.mensal.model.Diciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiciplinaRepository extends JpaRepository<Diciplina, Long> {
}
