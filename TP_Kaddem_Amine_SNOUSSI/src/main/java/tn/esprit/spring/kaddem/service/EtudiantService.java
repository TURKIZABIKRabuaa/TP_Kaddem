package tn.esprit.spring.kaddem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repository.DepartementRepository;
import tn.esprit.spring.kaddem.repository.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {
       EtudiantRepository etudiantRepository;
       DepartementRepository departementRepository;
       DepartementService departementService;


    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public List<Etudiant> retrieveEtudiantByContractSpecJPQL() {
        return etudiantRepository.retrieveEtudiantBySpecialiteJPQL();
    }

    @Override
    public List<Etudiant> retrieveEtudiantByContractSpecSQL() {
        return etudiantRepository.retrieveEtudiantBySpecialiteSQL();
    }
    @Override
    public Etudiant removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

        return null;
    }

    public void assignEtudiantToDepartement(Integer etudiantId, Integer departemntId) {
       Etudiant e=etudiantRepository.findById(etudiantId).get();
        Departement d=departementRepository.findById(departemntId).get();
        e.setDepartement(d);
        updateEtudiant(e);

    }
}
