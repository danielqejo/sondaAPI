package com.elo7.sonda.example.repository;

import com.elo7.sonda.example.entity.Sonda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SondaRepository extends JpaRepository<Sonda, Long> {
}

