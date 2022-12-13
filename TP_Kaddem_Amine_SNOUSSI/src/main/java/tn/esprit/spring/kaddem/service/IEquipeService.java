package tn.esprit.spring.kaddem.service;

import tn.esprit.spring.kaddem.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail
    Equipe updateEquipe (Equipe e);
    Equipe retrieveEquipe (Integer idEquipe);
    void faireEvoluerEquipes();
}
