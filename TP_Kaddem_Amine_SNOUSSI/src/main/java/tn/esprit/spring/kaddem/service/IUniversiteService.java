package tn.esprit.spring.kaddem.service;

import tn.esprit.spring.kaddem.entities.Universite;

import java.util.List;

public interface IUniversiteService {

    List<Universite> retrieveAllUniversites();
    Universite addUniversite(Universite e); // ajouter l’équipe avec son détail
    Universite updateUniversite (Universite e);
    Universite retrieveUniversite (Integer idUniversite);
    void assignUniversiteToDepartement(Integer IdUniversite, Integer IdDepartement);
}

