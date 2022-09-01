package com.elo7.testJr.campo.controller;

import com.elo7.testJr.campo.entity.Campo;
import com.elo7.testJr.campo.repository.CampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CampoService {
    @Autowired
    private CampoRepository campoRepository;

    @Transactional
    public Campo create(Campo campo) {
        return campoRepository.save(campo);
    }

//    @Transactional
//    @Query("UPDATE `test-sonda-db`.sonda SET posAtualX = ?posAtualX, posAtualY = ?posAtualY where id = ?id;")
//    public void moveSonda(@Param("id") Long id, @Param("posAtualX") int x, @Param("posAtualY") int y) { }

//    public Sonda getReferenceById(Long id) {
//        return
//    }

//    public int[] getPosAtual(Long id) {
//        Sonda sonda = sondaRepository.getReferenceById(id);
//        sonda.moveSonda();
//        return sonda.getPosAtual();
//    }

}
