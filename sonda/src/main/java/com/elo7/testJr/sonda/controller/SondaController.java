package com.elo7.testJr.sonda.controller;

import com.elo7.testJr.campo.entity.Campo;
import com.elo7.testJr.sonda.entity.Sonda;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sonda")
public class SondaController {
    @Autowired
    SondaService sondaService;

    @PostMapping("/{id}")
    private ResponseEntity<?> adicionaSonda(@RequestBody InputSondaDto dto, @PathVariable Long id){
        Optional<Campo> campo = sondaService.exist(id);
        Sonda sonda;
        if(!campo.isEmpty()) {
            try {
                sonda = sondaService.create(dto.toEntity(campo.get()));
            } catch (Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A posicao ja esta ocupada!");
            }
            return ResponseEntity.ok(OutputSondaDto.from(sonda));
        }

        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo não existe");
        }
    }

    @PostMapping("/moveSonda/{id}")
    private ResponseEntity<?> moveSonda(@PathVariable Long id){
        try {
            var sonda = sondaService.moveSonda(id);

            return ResponseEntity.ok(OutputSondaDto.from(sonda));
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A sonda colidiu!");
        } catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A sonda nao existe");
        }
    }

    @PostMapping("/viraSonda/{id}/{direcao}")
    private ResponseEntity<?> moveSonda(@PathVariable Long id, @PathVariable int direcao){
        if(direcao != -1 && direcao != 1) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Direcao invalida. Use -1 pra rotacao para esquerda e 1 para direita");

        var sonda = sondaService.viraSonda(id, direcao);

        return ResponseEntity.ok(OutputSondaDto.from(sonda));
    }
}
