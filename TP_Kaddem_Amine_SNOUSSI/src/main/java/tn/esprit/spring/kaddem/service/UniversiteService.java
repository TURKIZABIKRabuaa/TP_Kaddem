package tn.esprit.spring.kaddem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repository.DepartementRepository;
import tn.esprit.spring.kaddem.repository.UniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{
    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return  universiteRepository.findById(idUniversite).get();
    }

    @Override
    public void assignUniversiteToDepartement(Integer IdUniversite, Integer IdDepartement) {
        Universite u=universiteRepository.findById(IdUniversite).get();
        Departement d=departementRepository.findById(IdDepartement).get();
        u.getDepartementList().add(d);
        updateUniversite(u);
    }
}
