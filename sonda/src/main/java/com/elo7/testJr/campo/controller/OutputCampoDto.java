package com.elo7.testJr.campo.controller;

import com.elo7.testJr.campo.entity.Campo;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
public record OutputCampoDto(Long id, int largura, int altura) {
    public static OutputCampoDto from(Campo campo) {
        return new OutputCampoDto(campo.getId(), campo.getLargura(), campo.getAltura());
    }
}
