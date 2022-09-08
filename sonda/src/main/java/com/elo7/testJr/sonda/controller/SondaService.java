package com.elo7.testJr.sonda.controller;

import com.elo7.testJr.campo.entity.Campo;
import com.elo7.testJr.campo.repository.CampoRepository;
import com.elo7.testJr.sonda.SondaExceptions.SondaColidiuException;
import com.elo7.testJr.sonda.SondaExceptions.SondaSaiuDoEspacoObservavelExceptions;
import com.elo7.testJr.sonda.entity.Sonda;
import com.elo7.testJr.sonda.repository.SondaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

        if(sondaRepository.aPosicaoEhValida(campoId, pos[0], pos[1]).isEmpty()) {
            return sondaRepository.save(sonda);
        }

        throw new IllegalArgumentException("A posicao " + pos[0] + ' ' + pos[1] + " ja esta ocupada");
    }

    public Sonda moveSonda(Long id) throws SondaSaiuDoEspacoObservavelExceptions, SondaColidiuException {
        System.out.println(sondaRepository.sondaAtiva(id).isEmpty());

        if(!sondaRepository.sondaAtiva(id).isEmpty()){
            Sonda sonda = sondaRepository.getReferenceById(id);
            sonda.movimenta();
            int[] pos = sonda.getPosAtual();
            Long campoId = sonda.getCampo().getId();
            System.out.println(pos[0]);
            System.out.println(pos[1]);

            System.out.println(sondaRepository.aPosicaoEhValida(campoId, pos[0], pos[1]).size() > 1);
            if(sondaRepository.aPosicaoEhValida(campoId, pos[0], pos[1]).size() > 1) {
                throw new SondaColidiuException("A sonda colidiu na posicao " + pos[0] + ' ' + pos[1]);
            }

            else if (!campoRepository.estaDentroDoCampo(campoId, pos[0], pos[1]).isEmpty()) {
                sondaRepository.moveSonda(id, pos[0], pos[1]);
                return sonda;

            } else {
                sonda.setEstaAtivo(false);
                sondaRepository.save(sonda);
                throw new SondaSaiuDoEspacoObservavelExceptions("A sonda saiu da area observavel");
            }
        }

        throw new ObjectNotFoundException(HttpStatus.NOT_FOUND, "A sonda nao existe");
    }

    public Sonda viraSonda(Long id, int direcao) {
        if(!sondaRepository.sondaAtiva(id).isEmpty()){
            Sonda sonda = sondaRepository.getReferenceById(id);
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
