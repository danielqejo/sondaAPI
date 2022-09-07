package com.elo7.testJr.sonda.controller;

import com.elo7.testJr.campo.entity.Campo;
import com.elo7.testJr.campo.repository.CampoRepository;
import com.elo7.testJr.sonda.entity.Sonda;
import com.elo7.testJr.sonda.repository.SondaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SondaService {
    @Autowired
    private SondaRepository sondaRepository;
    @Autowired
    private CampoRepository campoRepository;

    @Transactional
    public Sonda create(Sonda sonda) {
        int[] pos = sonda.getPosAtual();
        Long campoId = sonda.getCampo().getId();

        if(sondaRepository.existsValidPositon(campoId, pos[0], pos[1]).isEmpty()) {
            return sondaRepository.save(sonda);
        }

        throw new IllegalArgumentException("A posicao " + pos[0] + ' ' + pos[1] + " ja esta ocupada");
    }

    public Sonda moveSonda(Long id){
        Optional<Sonda> exist = Optional.of(sondaRepository.getReferenceById(id));
        if(!exist.isEmpty() && sondaRepository.sondaAtiva(id)){
            Sonda sonda = exist.get();
            sonda.movimenta();
            int[] pos = sonda.getPosAtual();
            Long campoId = sonda.getCampo().getId();

            if(!sondaRepository.existsValidPositon(campoId, pos[0], pos[1]).isEmpty()) {
                throw new IllegalArgumentException("A sonda colidiu na posicao " + pos[0] + ' ' + pos[1]);
            }
            if (!campoRepository.estaDentroDoCampo(campoId, pos[0], pos[1]).isEmpty()) {
                throw new IllegalArgumentException("A sonda saiu da area observavel");
            }

            sondaRepository.moveSonda(id, pos[0], pos[1]);
            return sonda;
        }


        throw new ObjectNotFoundException(HttpStatus.NOT_FOUND, "A sonda nao existe");
    }

    public Sonda viraSonda(Long id, int direcao) {
        Optional<Sonda> exist = Optional.of(sondaRepository.getReferenceById(id));

        if(!exist.isEmpty() && sondaRepository.sondaAtiva(id)){
            Sonda sonda = exist.get();
            sonda.vira(direcao);

            sondaRepository.save(sonda);

            return sonda;
        }

        throw new ObjectNotFoundException(HttpStatus.NOT_FOUND, "A sonda nao existe");
    }

    public int[] getPosAtual(Long id) {
        Sonda sonda = sondaRepository.getReferenceById(id);
        sonda.movimenta();
        return sonda.getPosAtual();
    }

    public Optional<Campo> exist(Long campoId) {
        return campoRepository.findById(campoId);
    }

}
