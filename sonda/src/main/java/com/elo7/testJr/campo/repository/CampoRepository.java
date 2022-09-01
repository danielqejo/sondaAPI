package com.elo7.testJr.campo.repository;

import com.elo7.testJr.campo.entity.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampoRepository extends JpaRepository<Campo, Long> {
}
