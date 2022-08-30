package com.elo7.sonda.example.controller;

import com.elo7.sonda.example.entity.Sonda;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
public record InputSondaDto(int posInicial, Sonda.directions orientacao){

    @JsonCreator
    public InputSondaDto{}

    public Sonda toEntity() {
        return new Sonda(null, posInicial, orientacao);
    }
}
