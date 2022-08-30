package com.elo7.sonda.example.controller;

import com.elo7.sonda.example.repository.SondaRepository;
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
}
