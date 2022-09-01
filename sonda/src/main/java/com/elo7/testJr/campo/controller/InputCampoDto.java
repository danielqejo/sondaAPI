package com.elo7.testJr.campo.controller;

import com.elo7.testJr.campo.entity.Campo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
public record InputCampoDto(int largura, int altura) {
    @JsonCreator
    public InputCampoDto{}

    public Campo toEntity() {
        return new Campo(null, largura, altura);
    }
}
