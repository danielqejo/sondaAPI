package com.elo7.testJr.sonda.repository;

import com.elo7.testJr.sonda.entity.Sonda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
public interface SondaRepository extends JpaRepository<Sonda, Long> {
    @Transactional
    @Query("UPDATE Sonda SET posAtualX = :x, posAtualY = :y where id = :id")
    default void moveSonda(@Param("id") Long id, @Param("x") int x, @Param("y") int y) {}

    @Transactional
    @Query("SELECT id from Sonda where posAtualX = :x AND posAtualY = :y AND campo_id = :id")
    List<Long> existsValidPositon(@Param("id") Long id, @Param("x") int x, @Param("y") int y);

    @Transactional
    @Query("SELECT estaAtivo from Sonda where id = :id AND estaAtivo = true")
    boolean sondaAtiva(Long id);
}

