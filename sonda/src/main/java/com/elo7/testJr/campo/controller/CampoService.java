package com.elo7.testJr.campo.controller;

import com.elo7.testJr.campo.entity.Campo;
import com.elo7.testJr.campo.repository.CampoRepository;
import com.elo7.testJr.sonda.entity.Sonda;
import com.elo7.testJr.sonda.repository.SondaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CampoService {
    @Autowired
    private CampoRepository campoRepository;
    @Autowired
    SondaRepository sondaRepository;

    @Transactional
    public Campo create(Campo campo) {
        return campoRepository.save(campo);
    }

    @Transactional
    public boolean aPosicaoEhValida(Long campoId, int x, int y){
        return sondaRepository.existsValidPositon(campoId, x, y).isEmpty();
    }

}
