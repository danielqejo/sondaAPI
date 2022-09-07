package com.elo7.testJr.sonda.controller;

import com.elo7.testJr.campo.entity.Campo;
import com.elo7.testJr.sonda.entity.Sonda;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
public record OutputSondaDto (Long id, int[] posAtual, Sonda.directions directions, Campo campo) {
    public static OutputSondaDto from(Sonda sonda) {
        return new OutputSondaDto(sonda.getId(), sonda.getPosAtual(), sonda.getOrientacao(), sonda.getCampo());
    }
}
