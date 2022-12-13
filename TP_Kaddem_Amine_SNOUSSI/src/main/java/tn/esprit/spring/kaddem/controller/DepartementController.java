package tn.esprit.spring.kaddem.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.service.IDepartementService;

@AllArgsConstructor
@RestController
@RequestMapping("/departement")
public class DepartementController {
    private final IDepartementService iDepartementService;

    @PostMapping("addDepartement")
    public ResponseEntity<Departement> addDepartement(@RequestBody Departement ce) {

        System.out.printf(String.valueOf(ce));

        iDepartementService.addDepartement(ce);

        return new ResponseEntity<Departement>(HttpStatus.CREATED);

    }
}