package com.elo7.testJr.sonda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sonda")
public class SondaController {
    @Autowired
    SondaService sondaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<OutputSondaDto> adicionaSonada(@RequestBody InputSondaDto dto){
        var sonda = sondaService.create(dto.toEntity());
        return ResponseEntity.ok(OutputSondaDto.from(sonda));
    }

//    @PostMapping("{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    private ResponseEntity<OutputSondaDto> moveSonda(@PathVariable Long id){
//        int[] posAtual = sondaService.getPosAtual(id);
//        var sonda = sondaService.getReferenceById(id);
//
//        sondaService.moveSonda(id, posAtual[0], posAtual[1]);
//
//        return ResponseEntity.ok(OutputSondaDto.from(sonda));
//    }
}
