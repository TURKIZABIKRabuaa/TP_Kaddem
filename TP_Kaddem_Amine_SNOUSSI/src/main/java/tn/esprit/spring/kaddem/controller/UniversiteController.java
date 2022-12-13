package tn.esprit.spring.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.service.IUniversiteService;

@AllArgsConstructor
@RestController
@RequestMapping("/universite")
public class UniversiteController {
    private final IUniversiteService iUniversiteService;
    @PostMapping("/addUniversite")
    public ResponseEntity<Universite> addUniversite(@RequestBody Universite u) {

        iUniversiteService.addUniversite(u);

        return new ResponseEntity<Universite>(HttpStatus.CREATED);

    }
    @PostMapping("/assignuniversite")
    public ResponseEntity<Universite> assignuniversite(Integer Universiteid,Integer departementid) {
        iUniversiteService.assignUniversiteToDepartement(Universiteid,departementid);
        return new ResponseEntity<Universite>(HttpStatus.CREATED);

    }


}
