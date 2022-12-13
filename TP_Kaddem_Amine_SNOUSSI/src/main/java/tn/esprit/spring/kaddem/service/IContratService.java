package tn.esprit.spring.kaddem.service;

import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;

import java.util.List;

public interface IContratService {

    List<Contrat> retrieveAllContrat();
    Contrat addContrat(Contrat e);
    Contrat updateContrat (Contrat e);
    Contrat retrieveContrat (Integer idContrat);
    void addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    void retrieveAndUpdateStatusContrat();
}
