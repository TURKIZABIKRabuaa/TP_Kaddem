package tn.esprit.spring.kaddem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repository.DepartementRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class DepartementService implements IDepartementService{
    DepartementRepository departementRepository;

    @Override
    public List<Departement> retrieveAllDepartement() {
         return (List<Departement>) departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement e) {
        return departementRepository.save(e) ;
    }

    @Override
    public Departement updateDepartement(Departement e) {
        return departementRepository.save(e) ;
    }

    @Override
    public Departement retrieveDepartement(Integer idDepartement) {
        return departementRepository.findById(idDepartement).get();
    }
}
