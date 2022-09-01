package com.elo7.testJr.campo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campo")
public class CampoController {
    @Autowired
    CampoService campoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<OutputCampoDto> criaCampo(@RequestBody InputCampoDto dto){
        var campo = campoService.create(dto.toEntity());
        return ResponseEntity.ok(OutputCampoDto.from(campo));
    }
}
