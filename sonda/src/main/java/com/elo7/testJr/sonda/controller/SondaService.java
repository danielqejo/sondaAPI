package com.elo7.testJr.sonda.controller;

import com.elo7.testJr.sonda.entity.Sonda;
import com.elo7.testJr.sonda.repository.SondaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SondaService {
    @Autowired
    private SondaRepository sondaRepository;

    @Transactional
    public Sonda create(Sonda sonda) {
        return sondaRepository.save(sonda);
    }

//    @Transactional
//    @Query("UPDATE `test-sonda-db`.sonda SET posAtualX = ?posAtualX, posAtualY = ?posAtualY where id = ?id;")
//    public void moveSonda(@Param("id") Long id, @Param("posAtualX") int x, @Param("posAtualY") int y) {
//    }

//    public Sonda getReferenceById(Long id) {
//        return
//    }

    public int[] getPosAtual(Long id) {
        Sonda sonda = sondaRepository.getReferenceById(id);
        sonda.moveSonda();
        return sonda.getPosAtual();
    }
}
