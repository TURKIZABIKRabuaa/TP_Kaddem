package tn.esprit.spring.kaddem.service;

import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Equipe;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartement();
    Departement addDepartement(Departement e);
    Departement updateDepartement (Departement e);
    Departement retrieveDepartement (Integer idDepartement);

}
