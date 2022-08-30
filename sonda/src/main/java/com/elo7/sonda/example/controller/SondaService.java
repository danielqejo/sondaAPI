package com.elo7.sonda.example.controller;

import com.elo7.sonda.example.entity.Sonda;
import com.elo7.sonda.example.repository.SondaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
