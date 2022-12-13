package tn.esprit.spring.kaddem.service;

import tn.esprit.spring.kaddem.entities.Etudiant;

import java.util.List;


public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);


    Etudiant retrieveEtudiant(Integer idEtudiant);

    List<Etudiant> retrieveEtudiantByContractSpecJPQL();
    List<Etudiant> retrieveEtudiantByContractSpecSQL();
    Etudiant removeEtudiant(Integer idEtudiant);

    public void assignEtudiantToDepartement(Integer etudiantId, Integer departemntId);
}
