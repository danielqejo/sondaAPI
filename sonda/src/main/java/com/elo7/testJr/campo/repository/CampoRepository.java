package com.elo7.testJr.campo.repository;

import com.elo7.testJr.campo.entity.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CampoRepository extends JpaRepository<Campo, Long> {
    @Transactional
    @Query("SELECT id from Campo where (:x >= 0 AND :x <= largura) AND (:y >= 0 AND :y <= altura) AND id = :id")
    List<Long> estaDentroDoCampo(@Param("id") Long id, @Param("x") int x, @Param("y") int y);
}
