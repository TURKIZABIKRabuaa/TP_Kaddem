package tn.esprit.spring.kaddem.controller;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.service.IContratService;
import tn.esprit.spring.kaddem.service.IDepartementService;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {
    private final IContratService iContratService;

    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat ce) {

        System.out.printf(String.valueOf(ce));

        iContratService.addContrat(ce);

        return new ResponseEntity<Contrat>(HttpStatus.CREATED);

    }
}