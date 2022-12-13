package tn.esprit.spring.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.service.EtudiantService;
import tn.esprit.spring.kaddem.service.IEtudiantService;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/etudiant/")
public class EtudiantController {
    private IEtudiantService iEtudiantService;
    @PostMapping ("addEtudiant")
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody  Etudiant ce) {

        System.out.printf(String.valueOf(ce));

        iEtudiantService.addEtudiant(ce);

        return new ResponseEntity<Etudiant>(HttpStatus.CREATED);

    }


    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {

        return iEtudiantService.updateEtudiant(e);

    }

    @PutMapping("/removeEtudiant/{idEtudiant}")
    public Etudiant removeEtudiant(@PathVariable("idEtudiant") Integer idEtudiant) {

        return iEtudiantService.removeEtudiant(idEtudiant);

    }
}
