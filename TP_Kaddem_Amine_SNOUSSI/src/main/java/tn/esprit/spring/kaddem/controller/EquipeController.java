package tn.esprit.spring.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.kaddem.entities.Equipe;

import tn.esprit.spring.kaddem.service.IEquipeService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/equipe")
public class EquipeController {
 private final    IEquipeService iEquipeService;


    @PostMapping ("addEquipe")
    public ResponseEntity<Equipe> addEquipe(@RequestBody  Equipe ce) {

        System.out.printf(String.valueOf(ce));

        iEquipeService.addEquipe(ce);

        return new ResponseEntity<Equipe>(HttpStatus.CREATED);

    }
}
