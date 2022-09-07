package com.elo7.testJr.sonda.controller;

import com.elo7.testJr.campo.entity.Campo;
import com.elo7.testJr.sonda.entity.Sonda;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
public record InputSondaDto(int[] posInicial, Sonda.directions orientacao){
    @JsonCreator
    public InputSondaDto{}

    public Sonda toEntity(Campo campo) {
        return new Sonda(null, posInicial, orientacao, campo);
    }
}
