package com.elo7.sonda.example.controller;

import com.elo7.sonda.example.entity.Sonda;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
public record OutputSondaDto (Long id, int posAtual, Sonda.directions directions) {

    public static OutputSondaDto from(Sonda sonda) {
        return new OutputSondaDto(sonda.getId(), sonda.getPosAtual(), sonda.getOrientacao());
    }
}
