package tn.esprit.spring.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
}
