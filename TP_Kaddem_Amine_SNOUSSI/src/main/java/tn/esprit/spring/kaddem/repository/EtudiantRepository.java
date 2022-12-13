package tn.esprit.spring.kaddem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Niveau;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {

    List<Etudiant> findByDepartementIdDepartement(Integer idDepartement);
    List<Etudiant> findByEquipeListNiveau(Niveau niveau);
    //SQL
    @Query("Select e From Etudiant e,Contrat c Where c.specialite='SECURITE' and c.etudiant.idEtudiant=e.idEtudiant")
    List<Etudiant> retrieveEtudiantBySpecialiteJPQL();
//JPQL
    @Query(value = "Select e From etudiant e,contrat c Where c.specialite='SECURITE' and c.etudiant.idEtudiant=e.idEtudiant",nativeQuery = true)
    List<Etudiant> retrieveEtudiantBySpecialiteSQL();

}
